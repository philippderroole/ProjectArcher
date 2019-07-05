import processing.core.*;

public class Item extends Element
{
    float healthValue; //positiv oder negativ;
    float size; 
    
    public Item()
    {
        
    }
    
    
    public void update() {
        
    }
    
    public void show() {
        
    }
    
    public float checkPlayerCollision(PVector playerPosition, float playerSize) {
        float distance = playerPosition.sub(this.position).mag();
        float minDistance = playerSize/2 + this.size/2;
        if (distance < minDistance) {
            // System.out.println(distance + "; " + minDistance + " " + "collision");
            return healthValue;
        }
        return 0;
    }
    
}
