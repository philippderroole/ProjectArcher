import processing.core.*;
import java.util.*;

public class PlayerProjectile extends Projectile{


    
    public PlayerProjectile(PVector startPosition, PVector direction, float damage, ArrayList<String> effects, View view){
        speed = 50;
        size = 15;
        
        position = startPosition;
        this.direction = direction;
        this.damage = damage;
        this.view = view;
        
        
        rotation = (float) Math.toDegrees(direction.copy().heading()) + 90;
        // System.out.println(rotation);
    }
    
    
    
    public void show(){
        // int[] color = {200, 200, 220};
        // view.ellipse(position, size, size, 0, color);
        view.image("playerProjectile", 
            position.copy().sub(new PVector(view.getGridSize()/2, view.getGridSize()/2)),
            rotation);
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