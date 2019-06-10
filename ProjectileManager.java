import processing.core.*;
import java.util.*;

public class ProjectileManager extends PApplet{

    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    
    public ProjectileManager()    {

    }
    
    public void addPlayerProjectile(PVector dir, float damage,String[] effects) {
        PlayerProjectile projectile = new PlayerProjectile(dir, damage, effects);
        
    }
    
    public void shoot(){
        
    }
}
