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
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("№%s.  %s %n",items.get(i).getId() , items.get(i).getName());
        }
    }

    public void deleteItem(int number){
        items.remove(number-1);
    }

}