import processing.core.*;

public class Shooter extends Enemy{

    public Shooter(PVector position, View view, ProjectileManager projectileManager, float size){
        this.position = position;
        this.view = view;
        this.size = size;

        maxHealth = 500;
        health = maxHealth;
        damage = 50;
        collisionDamage = 2;
        maxDelay = random(1) * 10 + 25;
        currentDelay = maxDelay;

        this.projectileManager = projectileManager;
    }

    public void update(){

    }

    public void show(){
        // int[] color = {255,100,100};
        // view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);

        view.image("frog", 
            position.copy().sub(new PVector(view.getGridSize()/2, view.getGridSize()/2)),
            rotation);
        showHealthbar();

        showHealthbar();
    }

    //shooot
    public void attack(PVector targetDirection) {
        if (currentDelay <= 5) {

            targetDirection.sub(this.position);
            targetDirection.normalize();
            rotation = (float) Math.toDegrees(targetDirection.copy().mult(-1).heading()) - 90;
        }
        if (currentDelay <= 0) {
            // System.out.println("Feindbeschuss!!");

            projectileManager.addEnemyProjectile(this.position.copy(),targetDirection, damage);
            currentDelay = maxDelay;

        }
        currentDelay--;

    }
}
