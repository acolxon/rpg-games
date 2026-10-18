package entities.items;

import entities.TypeDamage;
import entities.character.Character;

public class DamageBoostItem extends Item{
    public final float damageMultiplier = 1.5f;

    public DamageBoostItem(){
        super("Предмет повышающий урон", "Увеличивает дополнительный урон персонажа навсегда на 50%", "Для персонажей физического типа урона увеличивает дополнительный урон персонажа 2 раза на 50%");
    }

    @Override
    public void useItem(Character ch){
        ch.setAdditionalDamage(ch.getAdditionalDamage() * damageMultiplier);
        passiveScill(ch);
    }

    @Override
    public void passiveScill(Character ch){
        if (ch.getTypeDamage() == TypeDamage.physical_damage) {
            ch.setAdditionalDamage(ch.getAdditionalDamage() * damageMultiplier);
        }
    }
}
