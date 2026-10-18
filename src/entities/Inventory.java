package entities;

import entities.items.Item;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory{
    private int maxCapacity = 10;
    private ArrayList<Item> items;

    public Inventory(Item... items){
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    public Item getItem(int number){
        return items.get(number-1);
    }

    public void displayList(){
        if(items.isEmpty()){
            System.out.println("Инвентарь пустой");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%s id:%s%n", items.get(i).getName(), items.get(i).getId());
        }
    }

    public void deleteItem(int number){
        items.remove(number-1);
    }

}