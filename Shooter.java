import processing.core.*;

public class Shooter extends Enemy{
    public Shooter(PVector position, View view){
        this.position = position;
        this.view = view;
    }
    
    public void update(){
        
    }
    
    public void show(){
        int[] color = {255,100,100};
        view.ellipse(position, 50, 50, 0, color);
        //System.out.println("show" + position);
    }
    
    
}