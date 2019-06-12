import processing.core.*;

public class Shooter extends Enemy{
    public Shooter(PVector position, View view){
        this.view = view;
    }
    
    public void update(){
        
    }
    
    public void show(){
        view.ellipse(position, 50, 50, 0);
    }
    
    
}
