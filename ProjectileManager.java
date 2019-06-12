import processing.core.*;
import java.util.*;

public class ProjectileManager extends PApplet{
    //Klassen zum Anmelden
    View view;

    //Variablen
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public ProjectileManager(){

    }

    public void login(View view){
        this.view = view;
    }

    public void update(){
        for(Projectile p : projectiles) {
            p.update();
        }
    }

    public void show(){
        for(Projectile p : projectiles) {
            p.show();
        }
    }

    public void addPlayerProjectile(PVector startPosition, PVector direction, float damage,String[] effects){
        PlayerProjectile projectile = new PlayerProjectile(startPosition, direction, damage, effects, view);
        projectiles.add(projectile);
    }
}
