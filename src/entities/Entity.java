package entities;

public abstract class Entity {
    private String name;
    private float health;
    private State state;

    public Entity(String name, float health, State state){
        this.name = name;
        this.health = Math.max(0, health);
        this.state = state;
    }

    public abstract void atackEntity(Entity entity);

    public void listToDuel(Entity[] entities){
        for (int i = 0; i < entities.length; i++) {
            System.out.printf("№%d. %s%n", i+1, entities[i].getName());
        }
    }

    public void chalangeToDuel(Entity entity){
        this.state = State.inBattle;
        entity.state = State.inBattle;
    }

    public void info(){
        System.out.println("======================");
        System.out.println("Информация о сущности:");
        System.out.printf("Имя: %s %n", this.getName());
        System.out.printf("Здоровье: %f %n",  this.getHealth());
        System.out.printf("Состояние: %s %n", this.getState());
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

    public void setState(State selectState){
        if (this.state != State.dead) {
            this.state = selectState;
            return;
        }
        System.out.println("Персонаж мёртв, менять состояние нельзя!");
    }

    public State getState(){
        return this.state;
    }
}
