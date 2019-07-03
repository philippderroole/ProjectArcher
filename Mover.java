import processing.core.*;

public class Mover extends Enemy{
    

    public Mover(PVector position, View view, ProjectileManager projectileManager, float size){
        this.position = position;
        this.view = view;
        this.size = size;

        maxHealth = 750;
        health = maxHealth;
        damage = 50;
        collisionDamage = 5;
        maxDelay = random(1) * 10 + 35;
        currentDelay = maxDelay;

        calculateDir();
        moveSpeed = 4;
        rotation = 0;

        this.projectileManager = projectileManager;
    }

    public void update(){        
        if (random(1) > 0.975) {
            // view.pApplet.noise(2);
            calculateDir();
        }
        
        // System.out.println(rotation);
        if (random(1) > 0.5) {
            move();
        }
    }

    public void show(){
        // int[] color = {120,150,100, 50};
        // view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);

        view.image("spider", 
            position.copy().sub(new PVector(view.getGridSize()/2, view.getGridSize()/2)),
            rotation);
        showHealthbar();
    }

    public void calculateDir() {
        moveDir = new PVector(random(1) - 0.5f, random(1) - 0.5f);
        moveDir.normalize();
        rotation = (float) Math.toDegrees(moveDir.copy().heading()) + 90;
    }

    public void move() {
        // System.out.println("dir: " + moveDir + "; speed: " + moveSpeed);
        position = position.add(moveDir.copy().mult(moveSpeed));
    }
    

    public void attack(PVector targetDirection) {
        if (currentDelay <= 0) {
            targetDirection.sub(this.position);
            targetDirection.normalize().mult(4);
            moveDir = targetDirection;
            currentDelay = maxDelay;
        }
        currentDelay--;
    }

}
