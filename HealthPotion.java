import processing.core.*;

public class HealthPotion extends Item
{
    public HealthPotion(PVector position, View view)
    {
        this.position = position;
        this.view = view;
    }
    
    public void update() {
        
    }
    
    public void show() {
        view.image("healthPotion", position, rotation);
    }
}
