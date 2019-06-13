import processing.core.*;

public abstract class Projectile extends Element{
    protected float size;
    //Variablen
    float damage;
    String[] effects; //noch nicht klar wie genau alle effekte verwaltet werden

    public Projectile(){
        damage = 100;
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
        PVector pToP = this.position.copy().sub(position);
        float pToPLength = (float) Math.sqrt(Math.pow(pToP.x, 2) + Math.pow(pToP.y, 2));
        float minLength = this.size + size / 2;
        if(pToPLength < minLength){
            return true;
        } else {
            return false;
        }
    }
}
