package entities.monsters;

import entities.State;
import entities.TypeDamage;
import events.EventBus;

public class Dragon extends Monster {
    final String type = "Dragon";

    public Dragon(String name, float health, State state, EventBus bus) {
        super(name, health, state, bus, 100.0f, 0.0f, TypeDamage.mage_damage);
    }
}