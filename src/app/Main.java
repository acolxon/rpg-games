package app;

import entities.Inventory;
import entities.State;
import entities.character.Warrior;
import entities.items.DamageBoostItem;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer();
        Warrior varvik = new Warrior("Varvik", 100, State.doesNothing, new Inventory(new DamageBoostItem(), new DamageBoostItem()));
        gamer.setCharacter(varvik);

        gamer.getCharacter().openInventory();
        gamer.getCharacter().info();
        gamer.getCharacter().useItemFromInventory(2);
        gamer.getCharacter().info();
        gamer.getCharacter().openInventory();
    }
}