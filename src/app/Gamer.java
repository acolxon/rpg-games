package app;

import entities.character.Character;

public class Gamer {
    Character character;

    public Gamer(){}

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter(){
        if(this.character != null){
            return this.character;
        }
        return null;
    }
}
