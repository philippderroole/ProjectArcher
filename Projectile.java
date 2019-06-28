import processing.core.*;

public abstract class Projectile extends Element{
    protected float size;
    //Variablen
    float damage;
    String[] effects; //noch nicht klar wie genau alle effekte verwaltet werden
    
    float speed;
    PVector direction;

    public Projectile(){
        damage = 100;
        
    }
    
    public void update(){
        position.add(direction.copy().mult(speed));
    }
    
    public void show(){
        view.ellipse(position, 50, 50, 0);
    }
    
    public float intersectsPlayer(PVector position, float size){
        return 0;
    }
    
    public float intersectsEnemy(PVector position, float size){
        return 0;
    }
    
    public boolean intersectsBlock(PVector position, float size){
        size = size/2;
        float leftB = position.x-size;
        float rightB = position.x+size;
        float topB = position.y-size;
        float bottomB = position.y+size;
        
        float leftP = this.position.x-this.size;
        float rightP = this.position.x+this.size;
        float topP = this.position.y-this.size;
        float bottomP = this.position.y+this.size;
        
        // PVector pToP = this.position.copy().sub(position);
        // float pToPLength = (float) Math.sqrt(Math.pow(pToP.x, 2) + Math.pow(pToP.y, 2));
        // float minLength = this.size + size / 2;
        // if(pToPLength < minLength){
        if(leftP < rightB && leftB < rightP && bottomP < topB && bottomB < topP) {
            System.out.println("true");
            return true;
        } else {
            return false;
        }
    }
    
    public PVector getNextStepPosition() {
        return position.copy().add(direction.copy().mult(speed));
    }
    public PVector getNextHalfStepPosition() {
        return position.copy().add(direction.copy().mult(speed/2));
    }
}
