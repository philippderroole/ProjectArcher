import processing.core.*;
import java.util.*;

public class Player extends Entity{
    
    //Klassen zum Anmelden
    ProjectileManager projectileManager;
    
    
    //Variablen
    private Enemy target;
    private PVector targetDir;
    private String[] effects;
    
    private float criticalStrikeChance;
    private float criticalStrikeMultiplier;
    private float movespeed;
    
    public Player(ProjectileManager projectileManager){
        this.projectileManager = projectileManager;
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
