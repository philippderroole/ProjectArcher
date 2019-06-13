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
            return pToB.copy().normalize().mult(pToBLength-minLength);
        } else {
            return new PVector();
        }
    } 
    
    public float distancetoEdge(float direction){
        return gridSize / 2;
    }
    
    public PVector getCenterPosition(){
        return new PVector(position.x + gridSize / 2, position.y + gridSize / 2);
    }
}
