import processing.core.*;

public class EnemyProjectile extends Projectile{

    
    public EnemyProjectile(PVector startPosition, PVector direction, float damage, View view){
        speed = 20;
        size = 15;
        
        position = startPosition;
        this.direction = direction;
        this.damage = damage;
        this.view = view;
    }
    
    
     public void update(){
        position.add(direction.copy().mult(speed));
    }
    
    public void show(){
        // int[] color = {255, 100, 100};
        // view.ellipse(position, size, size, 0, color);
        view.image("enemyProjectile", 
            position.copy().sub(new PVector(view.getGridSize()/2, view.getGridSize()/2)),
            rotation);
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