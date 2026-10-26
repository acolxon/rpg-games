package entities.character;

import entities.items.Item;
import entities.main.Entity;
import entities.inventory.Inventory;
import entities.State;
import entities.TypeDamage;
import entities.main.Position;
import events.EventBus;
import events.GameEvent;

public class Character extends Entity {
    private Inventory inventory;
    private float basicDamage = 20.0f;
    private TypeDamage typeDamage;
    private float additionalDamage;
    private float attackRange = 3.0f;

    public Character(String name, float health, State state, EventBus bus, Position position, Inventory inventory, float additionalDamage, TypeDamage typeDamage){
        super(name, health, state, bus, position);
        this.inventory = inventory;
        this.additionalDamage = Math.max(0, additionalDamage);
        this.typeDamage = typeDamage;
    }

    public void useItemFromInventory(int number){
        Item item = inventory.getItem(number);
        item.useItem(this);
        inventory.deleteItem(number);
        bus.publish(new GameEvent.ItemUsed(getName(), item.getName()));
    }

    @Override
    public void attackEntity(Entity entity) {
        float distance = position.distanceTo(entity.getPosition());

        if(distance <= attackRange){
            dealDamageTo(entity, basicDamage + additionalDamage);
        }
    }

    public void challengeToDuel(Entity entity){
        super.setState(State.inBattle);
        entity.setState(State.inBattle);
    }

    public float getAdditionalDamage() {
        return additionalDamage;
    }

    public void setAdditionalDamage(float additionalDamage) {
        this.additionalDamage = Math.max(0, additionalDamage);
    }

    public TypeDamage getTypeDamage() {
        return this.typeDamage;
    }

    public void setTypeDamage(TypeDamage td) {
        this.typeDamage = td;
    }
}
