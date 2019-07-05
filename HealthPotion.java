import processing.core.*;

public class HealthPotion extends Item
{
    public HealthPotion(PVector position, View view)
    {
        this.position = position;
        this.view = view;
        
        healthValue = 200;
        size = 20;
    }
    
    public void update() {
        
    }
    
    public void show() {
        view.image("healthPotion", position.copy().sub(new PVector(view.getGridSize()/2, view.getGridSize()/2)), rotation);
    }
    
    
}
