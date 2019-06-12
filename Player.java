import processing.core.*;
import java.util.*;

public class Player extends Entity{
    
    //Klassen zum Anmelden
    View view;
    ProjectileManager projectileManager;
    EnemyManager enemyManager;
    
    //Variablen
    float width = 20;
    float height = 20;
    
    private Enemy target;
    private PVector targetDir;
    private String[] effects;
    
    private float criticalStrikeChance;
    private float criticalStrikeMultiplier;
    private float movespeed = 2;
    
    public Player(){
    }
    
    public void login(View view, ProjectileManager projectileManager, EnemyManager enemyManager) {
        this.view = view;
        this.projectileManager = projectileManager;
        this.enemyManager = enemyManager;
    }
    
    public void update() {
        
    }
    
    public void show() {
        view.ellipse(position, width, height, rotation);
    }
    
    public void move(PVector direction){
        position.x += direction.x * movespeed;
        position.y += direction.y * movespeed;
    }
    
    public void targetNearestEnemy() {
        ArrayList<Enemy> enemies = enemyManager.getEnemies();
        int length = enemies.size();
        int minDist = (int) Math.pow(2,31);
        int aktDist;
        for (int i = 0; i < length; i++) {
            aktDist = (int) view.pApplet.dist(this.position.x,this.position.y,enemies.get(i).position.x, enemies.get(i).position.y);
            
        }
    }
    
    public void shoot() {
        if(isCriticalStrike()){
            projectileManager.addPlayerProjectile(targetDir, damage * criticalStrikeMultiplier, effects);
        } else {
            projectileManager.addPlayerProjectile(targetDir, damage, effects);
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
}
