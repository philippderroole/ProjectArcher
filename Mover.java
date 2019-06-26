import processing.core.*;

public class Mover extends Enemy{

    public Mover(PVector position, View view, ProjectileManager projectileManager, float size){
        this.position = position;
        this.view = view;
        this.size = size;

        maxHealth = 150;
        health = maxHealth;
        damage = 50;
        maxDelay = random(1) * 10 + 35;
        currentDelay = maxDelay;

        calculateDir();
        moveSpeed = 4;

        this.projectileManager = projectileManager;
    }

    public void update(){
        if (random(1) > 0.975) {
            // view.pApplet.noise(2);
            calculateDir();
        }
        if (random(1) > 0.5) {
            move();
        }
    }

    public void show(){
        int[] color = {120,150,100};
        view.ellipse(position, size, size, 0, color);
        // System.out.println("show" + size);

        showHealthbar();
    }

    public void calculateDir() {
        moveDir = new PVector(random(1) - 0.5f, random(1) - 0.5f);
        moveDir.normalize();
    }

    public void move() {
        // System.out.println("dir: " + moveDir + "; speed: " + moveSpeed);
        position = position.add(moveDir.copy().mult(moveSpeed));
    }

    public void attack(PVector targetDirection) {
        if (currentDelay <= 0) {
            targetDirection.sub(this.position);
            targetDirection.normalize().mult(2);
            moveDir = targetDirection;
            currentDelay = maxDelay;
        }
        currentDelay--;
    }

}
