import java.util.*;

public class ItemManager 
{
    //Variablen
    private ArrayList<Item> items;
    private float gridSize;
    
    public ItemManager(float gridSize)
    {
        items = new ArrayList<Item>();
    }
    
    public void login() {
        
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
}
