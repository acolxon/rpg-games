package entities.character;

import entities.inventory.Inventory;
import entities.State;
import entities.TypeDamage;
import entities.main.Position;
import events.EventBus;

public class Warrior extends Character{
    final String type = "Warrior";

    public Warrior(String name, float health, State state, EventBus bus, Position position, Inventory inventory){
        super(name, health, state, bus,position, inventory,30.0f, TypeDamage.physical_damage);
    }
}
