package entities.monsters;

import entities.State;
import entities.TypeDamage;
import entities.main.Entity;
import entities.main.Position;
import events.EventBus;

public abstract class Monster extends Entity {
    private float basicDamage;
    private float additionalDamage;
    private TypeDamage typeDamage;

    public Monster(String name, float health, State state, EventBus bus, Position position,
                   float basicDamage, float additionalDamage, TypeDamage typeDamage) {
        super(name, health, state, bus, position);
        this.basicDamage = Math.max(0, basicDamage);
        this.additionalDamage = Math.max(0, additionalDamage);
        this.typeDamage = typeDamage;
    }

    @Override
    public void attackEntity(Entity entity) {
        dealDamageTo(entity, basicDamage + additionalDamage);
    }

    public float getBasicDamage() {
        return basicDamage;
    }

    public float getAdditionalDamage() {
        return additionalDamage;
    }

    public void setAdditionalDamage(float additionalDamage) {
        this.additionalDamage = Math.max(0, additionalDamage);
    }

    public TypeDamage getTypeDamage() {
        return typeDamage;
    }

    public void setTypeDamage(TypeDamage typeDamage) {
        this.typeDamage = typeDamage;
    }
}