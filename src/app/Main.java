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
        Gamer gamer = new Gamer();
        EventBus bus = new EventBus();
        bus.subscribe(new GameCli());


        Warrior varvik = new Warrior("Varvik", 100, State.doesNothing, bus, new Position(10, 20), new Inventory(new DamageBoostItem(), new DamageBoostItem()));
        gamer.setCharacter(varvik);
        Character hero = gamer.getCharacter();

        Dragon dragon = new Dragon("Ледяной дракон", 100.0f, State.eat, bus, new Position(150, 0));
        hero.attackEntity(dragon);
        hero.useItemFromInventory(1);
        hero.attackEntity(dragon);
        hero.attackEntity(dragon);
    }
}