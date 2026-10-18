package entities.monsters;

import entities.Entity;
import entities.State;

public class Dragon extends Monster{
    float basicDamage = 100.0f;
    final String type = "Dragon";

    public Dragon(String name, float health, State state) {
        super(name, health, state);
    }

    @Override
    public void atackEntity(Entity entity) {
        entity.setHealth(entity.getHealth()-this.basicDamage);
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("Тип: %s %n", this.type);
    }
}
