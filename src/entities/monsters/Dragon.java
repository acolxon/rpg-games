package entities.monsters;

import entities.State;
import entities.TypeDamage;
import entities.main.Position;
import events.EventBus;

public class Dragon extends Monster {
    final String type = "Dragon";

    public Dragon(String name, float health, State state, EventBus bus, Position position) {
        super(name, health, state, bus, position, 100.0f, 0.0f, TypeDamage.mage_damage);
    }
}