import processing.core.*;
import java.util.*;

public class ProjectileManager extends PApplet{
    //Klassen zum Anmelden
    PApplet pApplet;
    
    //Variablen
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    
    public ProjectileManager(){

    }
    
    public void login(PApplet pApplet){
        this.pApplet = pApplet;
    }
    
    public void update(){
        projectiles.forEach((p) -> p.update());
    }
    
    public void show(){
        projectiles.forEach((p) -> p.show());
    }
    
    public void addPlayerProjectile(PVector direction, float damage,String[] effects){
        PlayerProjectile projectile = new PlayerProjectile(direction, damage, effects);
    }
}
