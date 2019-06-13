import processing.core.*;

public class PlayerProjectile extends Projectile{

    private float speed;
    private PVector direction;
    
    public PlayerProjectile(PVector startPosition, PVector direction, float damage, String[] effects, View view){
        speed = 20;
        
        position = startPosition;
        this.direction = direction;
        this.view = view;
    }
    
    public void update(){
        position.add(direction.copy().mult(speed));
    }
    
    public void show(){
        view.ellipse(position, 10, 10, 0);
    }
    
    public float intersectsEnemy(PVector position, float size){
        PVector pToP = this.position.copy().sub(position);
        float pToPLength = (float) Math.sqrt(Math.pow(pToP.x, 2) + Math.pow(pToP.y, 2));
        float minLength = this.size + size / 2;
        if(pToPLength < minLength){
            System.out.println("Treffer!");
            return damage;
        } else {
            return 0;
        }
    }
}
