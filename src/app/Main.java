package app;

import cli.GameCli;
import entities.inventory.Inventory;
import entities.State;
import entities.character.Warrior;
import entities.items.DamageBoostItem;
import entities.main.Position;
import entities.monsters.Dragon;
import events.EventBus;
import entities.character.Character;

public class Main {
    public static void main(String[] args) {
//        Gamer gamer = new Gamer();
//        EventBus bus = new EventBus();
//        bus.subscribe(new GameCli());
//
//
//        Warrior varvik = new Warrior("Varvik", 100, State.doesNothing, bus, new Position(2, 2), new Inventory(new DamageBoostItem(), new DamageBoostItem()));
//        gamer.setCharacter(varvik);
//        Character hero = gamer.getCharacter();
//
//        Dragon dragon = new Dragon("Ледяной дракон", 100.0f, State.eat, bus, new Position(2, 9));
//        hero.attackEntity(dragon);
//        hero.useItemFromInventory(1);
//        hero.attackEntity(dragon);
//        hero.attackEntity(dragon);
//
//        System.out.println(hero.getPosition().distanceTo(dragon.getPosition()));
        EventBus bus = new EventBus();
        Dragon dragon = new Dragon("Дракон", 100, State.doesNothing, bus, new Position(4, 5));

        dragon.setSpeed(1f);
        dragon.setTarget(new Position(9, 12));
        float dt = 0.1f;

        for (int i = 1; i <= 110; i++) {
            dragon.update(dt);
            System.out.println(i);
            System.out.println("t=" + (i * dt) + "с  позиция: " + dragon.getPosition());
        }

    }
}