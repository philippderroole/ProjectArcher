import processing.core.*;

public class Shooter extends Enemy{
    public Shooter(PVector position, View view, float size){
        this.position = position;
        this.view = view;
        
        this.size = size;
    }
    
    public void update(){
        
    }
    
    public void show(){
        int[] color = {255,100,100};
        view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);
    }
    
    
}
