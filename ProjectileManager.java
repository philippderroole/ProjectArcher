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
    
    public float getPlayerDamage(PVector position, float size){
        // blocks.get(2).intersects(position.copy(), size);
        float damage = 0;
        for(Projectile p : projectiles) {
            damage += p.intersectsPlayer(position.copy(), size);
        }
        return damage;
    }
    
    public float getEnemyDamage(PVector position, float size){
        // blocks.get(2).intersects(position.copy(), size);
        float damage = 0;
        float previous = 0;
        for(int i = projectiles.size() - 1; i >= 0; i--) {
            damage += projectiles.get(i).intersectsEnemy(position.copy(), size);
            if(damage > previous){
                projectiles.remove(i);
            }
            previous = damage;
        }
        return damage;
    }
    
    public void checkBlocks(PVector position, float size){
        // blocks.get(2).intersects(position.copy(), size);
        for(int i = projectiles.size() - 1; i >= 0; i--) {
            if(projectiles.get(i).intersectsBlock(position.copy(), size)){
                projectiles.remove(i);
            }
        }
    }
}
