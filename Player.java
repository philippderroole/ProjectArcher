import processing.core.*;
import java.util.*;

public class Player extends Element{

    //Klassen zum Anmelden
    View view;
    ProjectileManager projectileManager;
    EnemyManager enemyManager;

    //Variablen
    private float size;

    private Enemy target;
    private PVector targetDirection;
    private String[] effects;

    private float maxHealth;
    private float health;
    private float damage;
    private float criticalStrikeChance;
    private float criticalStrikeMultiplier;
    private float attackspeed;
    private float currentDelay;
    private float movespeed;
    private boolean moving; //macht diese Variavble sinn? ich denke für das schießen schon zum testen
    //außerdem kann man dann das target enemy nur dann machen wenn man aufhörtt zu laufen und anfängr zu schießen
    //und nicht dauerjaft sodass auch mal ein enemy totgeschossen wird

    public Player(float size){
        position = new PVector(100,960/2);
        this.size = size;
        maxHealth = 1000;
        health = maxHealth;
        damage = 100;
        criticalStrikeChance = 10;
        criticalStrikeMultiplier = 2;
        attackspeed = 0.5f;
        currentDelay = attackspeed * 30;
        movespeed = size/6;
    }

    public void login(View view, ProjectileManager projectileManager, EnemyManager enemyManager){
        this.view = view;
        this.projectileManager = projectileManager;
        this.enemyManager = enemyManager;
    }

    public void update(){
        if(enemyManager.isEnemy() && !moving){
            currentDelay--;
            if(currentDelay <= 0){
                targetNearestEnemy();
                shoot();
                resetDelay();
            }
        } else {
            resetDelay();
        }
    }

    public void show(){
        int[] color = {255,255,255};
        view.ellipse(position, size, size, rotation, color);
        //leben
        color = new int [] {100,100,100};
        view.rect(new PVector(position.x-50, position.y-75), 100, 12, 0, color);
        color = new int[] {150,220,150};
        int length = (int) (health/maxHealth * 100);
        view.rect(new PVector(position.x-50, position.y-75), length, 12, 0, color);
        color = new int[] {0, 0, 0};
        view.text(String.valueOf((int) health), position.x+2, position.y - 78, 20, color);
        color = new int[] {255, 255, 255};
        view.text(String.valueOf((int) health), position.x, position.y - 80, 20, color);
    }

    public void correctPosition(PVector direction){
        position.add(direction.copy());
    }

    public void move(PVector direction){
        if (direction.mag() > 0) {
            position.add(direction.copy().mult(movespeed));
            if (!moving) {
                moving = true;
                // System.out.println("moving");
            }
        } else if (moving) {
            moving = false;
            // System.out.println("standing");
        }
    }

    public void targetNearestEnemy(){
        targetDirection = enemyManager.getNearestEnemyDirection(position.copy());
    }

    public void shoot(){
        if(isCriticalStrike()){
            projectileManager.addPlayerProjectile(position.copy(),targetDirection.copy(), damage * criticalStrikeMultiplier, effects);
            System.out.println("Kritischer Schuss!");
        } else {
            projectileManager.addPlayerProjectile(position.copy(),targetDirection, damage, effects);
            System.out.println("Schuss!");
        }
    }

    public void getDamage(float damage){
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }

    public boolean isDead() {
        if (health <= 0)
            return true;
        else 
            return false;
    }

    public boolean isCriticalStrike(){
        float f = random(100);
        if(f <= criticalStrikeChance){
            return true;
        } else {
            return false;
        }
    }

    public void resetDelay(){
        currentDelay = attackspeed * 30;
    }

    public float getSize(){
        return size;
    }
}
