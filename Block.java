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
        System.out.println("hi");
    }

    public void showHitbox(){
        
    }
    
    public void setPosition(PVector gridPosition){
        this.position = new PVector(gridPosition.x * gridSize, gridPosition.y * gridSize);
    }
    
    public float intersects(PVector position){
        // PVector center = new PVector(this.position.x + (gridSize / 2), this.position.y + (gridSize / 2));
        
        // PVector c = center.copy();
        // PVector p = position.copy();
        // float distance = center.dist(position);
        // float angle = (float) Math.toDegrees( PVector.angleBetween(c.normalize(), p.normalize()));
        // // float f = center.dist(position) - distancetoEdge(PVector.angleBetween(center, position));
        // System.out.println(Math.toDegrees(c.heading()));
        // System.out.println(Math.toDegrees(p.heading()));
        // System.out.println(Math.toDegrees(p.sub(c).heading()));
        // System.out.println(center.x + "  " + center.y);
        // System.out.println("dist" + distance);
        // System.out.println("angle" + angle);
        // // System.out.println("f" + f);
        return 0;
    } 
    
    public float distancetoEdge(float direction){
        while(direction > 90){
            direction -= 90;
        }
        
        return (float) ((0.5 * gridSize) / Math.cos(direction));
    }
}
