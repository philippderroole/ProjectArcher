import processing.core.*;

public class Block extends Element{
    
    private float gridSize;
    
    public Block(PVector position, float gridSize, View view){
        this.gridSize = gridSize;
        setPosition(position);
        this.view = view;
    }
    
    public void show(){
        view.rect(position, gridSize, gridSize, 0);
    }

    public void showHitbox(){
        
    }
    
    public void setPosition(PVector position){
        this.position = new PVector(position.x * gridSize, position.y * gridSize);
    }
    
    public PVector getPosition(){
        return position;
    }
}
