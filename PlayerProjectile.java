import processing.core.*;

public class PlayerProjectile extends Projectile{
    
    float speed;
    PVector direction;
    
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
}
