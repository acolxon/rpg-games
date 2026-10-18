package entities.character;

import entities.Entity;
import entities.Inventory;
import entities.State;
import entities.TypeDamage;
import entities.items.Item;

public class Character extends Entity {
    private Inventory inventory;
    private float basicDamage = 20.0f;
    private TypeDamage typeDamage;
    private float additionalDamage;

    public Character(String name, float health, State state, Inventory inventory,float additionalDamage, TypeDamage typeDamage){
        super(name, health, state);
        this.inventory = inventory;
        this.additionalDamage = Math.max(0, additionalDamage);
        this.typeDamage = typeDamage;
    }

    public void useItemFromInventory(int number){
        this.inventory.getItem(number).useItem(this);
        this.inventory.deleteItem(number);
    }

    public void openInventory(){
        this.inventory.displayList();
    }

    @Override
    public void info() {
        super.info();
        System.out.printf(" Базовый урон: %f%n Дополнительный урон: %f%n Тип урона: %s%n", basicDamage, additionalDamage, typeDamage);
    }

    @Override
    public void atackEntity(Entity entity) {
        if (entity.getState() == State.dead) {
            System.out.printf("%s атаковать нельзя, он уже мёртв %n", entity.getName());
            return;
        }

        System.out.printf("%s Атаковал %s%n",super.getName(), entity.getName());
        entity.setHealth(entity.getHealth() - (basicDamage + additionalDamage));

        if (entity.getHealth() <= 0.0) {
            entity.setState(State.dead);
//            System.out.printf("%s Умер!!! %n", entity.getName());
        }
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
