import processing.core.*;
import java.util.*;

public class Player extends Entity{
    
    //Klassen zum Anmelden
    View view;
    ProjectileManager projectileManager;
    
    
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
    
    public void login(View view, ProjectileManager projectileManager) {
        this.view = view;
        this.projectileManager = projectileManager;
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
    
    public void shoot() {
        if(isCriticalStrike()){
            projectileManager.addPlayerProjectile(targetDir, damage * criticalStrikeMultiplier, effects);
        } else {
            projectileManager.addPlayerProjectile(targetDir, damage, effects);
        }
    }
    
    public boolean isCriticalStrike(){
        // float f = pApplet.random(100);
        // if(f <= criticalStrikeChance){
             return true;
        // } else {
            // return false;
        // }
    }
}
