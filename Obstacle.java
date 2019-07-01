import processing.core.*;

public class Obstacle extends Element{
    
    private float gridSize;
    private String image;
    
    public Obstacle(){
    }
    
    public void show(){
        // view.rect(position, gridSize, gridSize, 0);
        view.image(image, position, rotation);
    }

    public void showHitbox(){
        
    }
    
    public void setPosition(PVector gridPosition){
        this.position = new PVector(gridPosition.x * gridSize, gridPosition.y * gridSize);
    }
    
    public PVector correctIntersectsCircle(PVector position, float size){
        return null;
    } 
    
    public float distancetoEdge(float direction){
        float angle = (float) Math.toDegrees(direction);
         angle -= 180;
         angle = Math.abs(angle);
        int i = 0;
        while(angle > 45) {
            angle -= 45;
            i++;
        }
        if (i%2==0) {
                angle = -angle + 45;
            }
        angle += 45;
        return( (float) ((gridSize / 2) / ( Math.sin(Math.toRadians(angle)))));
        //((gridSize / 2) / (float) Math.sin(Math.toRadians(angle)));
         // return gridSize / 2;
    }
    
    public boolean intersectsCircle(PVector position, float size){
        return false;
    } 
    
    public PVector getCenterPosition(){
        return new PVector(position.x + gridSize / 2, position.y + gridSize / 2);
    }
    
    public float getGridSize() {
        return gridSize;
    }
    
}
