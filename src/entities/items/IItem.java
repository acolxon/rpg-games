package entities.items;

import entities.character.Character;

public interface IItem {
    void useItem(Character ch);
    void passiveScill(Character ch);
}
