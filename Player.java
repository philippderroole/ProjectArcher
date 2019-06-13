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
    
    public Player(){
        size = 50;
        maxHealth = 1000;
        health = maxHealth;
        damage = 100;
        criticalStrikeChance = 10;
        criticalStrikeMultiplier = 2;
        attackspeed = 0.5f;
        currentDelay = attackspeed * 30;
        movespeed = 8;
    }

    public void login(View view, ProjectileManager projectileManager, EnemyManager enemyManager){
        this.view = view;
        this.projectileManager = projectileManager;
        this.enemyManager = enemyManager;
    }

    public void update(){
        if(enemyManager.isEnemy()){
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
        view.ellipse(position, size, size, rotation);
    }

    public void move(PVector direction){
        position.add(direction.copy().mult(movespeed));
    }

    public void targetNearestEnemy(){
        targetDirection = enemyManager.getNearestEnemyDirection(position.copy());
    }

    public void shoot(){
        if(isCriticalStrike()){
            projectileManager.addPlayerProjectile(position.copy(),targetDirection.copy(), damage * criticalStrikeMultiplier, effects);
            System.out.println("Kritischer Treffer");
        } else {
            projectileManager.addPlayerProjectile(position.copy(),targetDirection, damage, effects);
            System.out.println("Schuss!");
        }
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
