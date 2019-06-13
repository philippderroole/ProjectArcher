import processing.core.*;

public abstract class Enemy extends Element{
    
    protected float size;
    
    public Enemy(){

    }
    
    public void show(){
        view.rect(position, 50, 50, 0);
    }
    
    public float getSize(){
        return size;
    }
}
