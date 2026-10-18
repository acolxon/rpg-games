package entities.items;

import entities.character.Character;

import java.util.UUID;

public abstract class Item {
    private final String id;
    public String name;
    public String itemDescription;
    public String passiveDescription;

    public Item(String name, String itemDescription, String passiveDescription){
        this.id = generateUUID();
        this.name = name;
        this.itemDescription = itemDescription;
        this.passiveDescription = passiveDescription;
    }

    public String getName() {
        return name;
    }

    public abstract void useItem(Character ch);

    public abstract void passiveScill(Character ch);

    public String getInfo() {
        String message = String.format(
                "Описание предмета: %n%s%nОписание пассивной способности:%n%s%n", itemDescription, passiveDescription
        );
        return message;
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
