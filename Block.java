import processing.core.*;

public class Block extends Element{
    
    private float gridSize;
    
    public Block(PVector position, float gridSize, PApplet pApplet){
        this.gridSize = gridSize;
        setPosition(position);
        this.pApplet = pApplet;
    }
    
    public void show(){
        System.out.println(pApplet);
        pApplet.pushMatrix();
        pApplet.translate(position.x, position.y);
        pApplet.fill(0);
        pApplet.stroke(0);
        pApplet.rect(0,0,gridSize,gridSize);
        pApplet.rotate(rotation);
        pApplet.popMatrix();
    }

    public void showHitbox(){
        pApplet.pushMatrix();
        pApplet.translate(position.x, position.y);
        pApplet.noFill();
        pApplet.stroke(255, 0, 0);
        pApplet.rect(0,0,gridSize,gridSize);
        pApplet.rotate(rotation);
        pApplet.popMatrix();
    }
    
    public void setPosition(PVector position){
        this.position = new PVector(position.x * gridSize, position.y * gridSize);
    }
    
    public PVector getPosition(){
        return position;
    }
}
