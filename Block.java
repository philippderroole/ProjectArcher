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
    
    public void setPosition(PVector gridPosition){
        this.position = new PVector(gridPosition.x * gridSize, gridPosition.y * gridSize);
    }
    
    public PVector intersectsPlayer(PVector position, float size){
        PVector pToB = getCenterPosition().sub(position);
        float pToBLength = (float) Math.sqrt(Math.pow(pToB.x, 2) + Math.pow(pToB.y, 2));
        float minLength = distancetoEdge(pToB.heading()) + size / 2; //Übergabe noch irrelevant
        if(pToBLength < minLength){
            // // // System.out.println("Intersection!");
            // System.out.println(pToB.copy().normalize().mult(-minLength));
            return pToB.copy().normalize().mult(pToBLength- minLength);
        } else {
            return new PVector();
        }
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
        PVector pToB = getCenterPosition().sub(position);
        float pToBLength = (float) Math.sqrt(Math.pow(pToB.x, 2) + Math.pow(pToB.y, 2));
        float minLength = distancetoEdge(pToB.heading()) + size / 2; //Übergabe noch irrelevant
        if(pToBLength < minLength){
            // // // System.out.println("Intersection!");
            // System.out.println(pToB.copy().normalize().mult(-minLength));
            return true;
        } else {
            return false;
        }
    } 
    
    public PVector getCenterPosition(){
        return new PVector(position.x + gridSize / 2, position.y + gridSize / 2);
    }
    
    public float getGridSize() {
        return gridSize;
    }
    
}
