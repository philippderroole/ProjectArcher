import processing.core.*;

public class Shooter extends Enemy{
    
    
    public Shooter(PVector position, View view, ProjectileManager projectileManager, float size){
        this.position = position;
        this.view = view;
        
        this.size = size;
        
        maxDelay = 30;
        currentDelay = maxDelay;
        
        this.projectileManager = projectileManager;
    }
    
    public void update(){
        
    }
    
    public void show(){
        int[] color = {255,100,100};
        view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);
    }
    
    
    public void shoot(PVector position) {
        if (currentDelay <= 0) {
            targetDirection = position.sub(this.position).normalize();
            projectileManager.addEnemyProjectile(this.position.copy(),targetDirection, damage);
        }
        currentDelay--;
       
    }
    
}
