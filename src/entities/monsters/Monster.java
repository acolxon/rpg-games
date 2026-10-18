package entities.monsters;

import entities.Entity;
import entities.State;

public abstract class Monster extends Entity {
    public Monster(String name, float health, State state){
        super(name, health, state);
    }
}
