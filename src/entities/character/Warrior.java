package entities.character;

import entities.Entity;
import entities.Inventory;
import entities.State;
import entities.TypeDamage;

public class Warrior extends Character{
    final String type = "Warrior";

    public Warrior(String name, float health, State state, Inventory inventory){
        super(name, health, state, inventory,30.0f, TypeDamage.physical_damage);
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("Тип: %s %n", this.type);


        System.out.println("======================");
    }
}
