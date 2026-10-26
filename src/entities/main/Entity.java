package entities.main;

import entities.State;
import events.EventBus;
import events.GameEvent;

public abstract class Entity {
    private String name;
    private float health;
    private State state;
    protected final EventBus bus;
    protected Position position;

    protected float speed;
    protected Position target;

    public Entity(
            String name,
            float health,
            State state,
            EventBus bus,
            Position position
    ){
        this.name = name;
        this.health = Math.max(0, health);
        this.state = state;
        this.bus = bus;
        this.position = position;
    }

    public abstract void attackEntity(Entity entity);

    protected void dealDamageTo(Entity target, float damage){
        if (this.state == State.dead || target.getState() == State.dead) return;
        target.setHealth(target.getHealth() - damage);
        bus.publish(new GameEvent.Attack(name, target.getName(), damage, target.getHealth()));
        if (target.getHealth() <= 0) target.die();
    }

    protected void die(){
        this.setState(State.dead);
        bus.publish(new GameEvent.Death(this.name));
    }

    public void update(float dt){
        if (state == State.dead || target == null) return;

        float distance = position.distanceTo(target);
        float step = dt * speed;

        if (distance <= step){
            position = target;
            target = null;
            return;
        }

        Position direction = target.minus(position).normalized();
        position = position.plus(direction.times(step));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = Math.max(0, health);
    }

    public void setState(State state){
        if (this.state == State.dead) {
            throw new IllegalStateException("Персонаж мёртв, менять состояние нельзя!");
        }
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public Position getTarget() {
        return target;
    }

    public void setTarget(Position target) {
        this.target = target;
    }
}
