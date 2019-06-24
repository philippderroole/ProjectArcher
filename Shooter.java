import processing.core.*;

public class Shooter extends Enemy{
    
    
    public Shooter(PVector position, View view, ProjectileManager projectileManager, float size){
        this.position = position;
        this.view = view;
        this.size = size;
        
        maxHealth = 200;
        health = maxHealth;
        damage = 50;
        maxDelay = 40;
        currentDelay = maxDelay;
        
        this.projectileManager = projectileManager;
    }
    
    public void update(){
        
    }
    
    public void show(){
        int[] color = {255,100,100};
        view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);
        
        showHealthbar();
    }
    
    
    public void shoot(PVector targetDirection) {
        if (currentDelay <= 0) {
            // System.out.println("Feindbeschuss!!");
            targetDirection.sub(this.position);
            targetDirection.normalize();
            projectileManager.addEnemyProjectile(this.position.copy(),targetDirection, damage);
            currentDelay = maxDelay;
        }
        currentDelay--;
       
    }
    
}
