import java.util.*;
import processing.core.*;

public class ItemManager 
{
    //Variablen
    private ArrayList<Item> items;
    private float gridSize;
    
    //Klassen zum Anmelden
    private View view;
    
    public ItemManager(float gridSize)
    {
        items = new ArrayList<Item>();
    }
    
    public void login(View view) {
        this.view = view;
    }
    
    public void addHealthPotion(PVector position) {
        HealthPotion potion = new HealthPotion(position, view);
        items.add(potion);
    }
    
    public void update() {
        for (Item i : items) {
            i.update();
        }
    }
    
    public void show() {
        for (Item i : items) {
            i.show();
        }
    }
    
    public void clearItems() {
        items = new ArrayList<Item>();
    }
    
    public float checkPlayerCollision(PVector playerPosition, float playerSize) {
        float health = 0;
        for (int i = items.size() -1; i >= 0; i --) {
            Item item = items.get(i);
            float addHealth = item.checkPlayerCollision(playerPosition, playerSize);
            if (addHealth > 0) {
                items.remove(item);
            }
            health += addHealth;
        }
        return health;
    }
}
