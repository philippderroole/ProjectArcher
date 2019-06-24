import processing.core.*;

public class EnemyProjectile extends Projectile{

    
    public EnemyProjectile(PVector startPosition, PVector direction, float damage, View view){
        speed = 8;
        
        position = startPosition;
        this.direction = direction;
        this.view = view;
    }
    
    
     public void update(){
        position.add(direction.copy().mult(speed));
    }
    
    public void show(){
        int[] color = {255, 100, 100};
        view.ellipse(position, 10, 10, 0, color);
    }
    
    public float intersectsPlayer(PVector position, float size){
        PVector pToB = this.position.copy().sub(position);
        float pToBLength = (float) Math.sqrt(Math.pow(pToB.x, 2) + Math.pow(pToB.y, 2));
        float minLength = this.size + size / 2;
        if(pToBLength < minLength){
            return damage;
        } else {
            return 0;
        }
    }
}