import processing.core.*;

public abstract class Enemy extends Entity{
    
    public Enemy(){

    }
    
    public void show(){
        view.rect(position, 50, 50, 0);
    }
}
