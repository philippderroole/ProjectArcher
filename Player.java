import processing.core.*;
import java.util.*;

public class Player extends Entity{
    
    //anmelden
    ProjectileManager pm;
    
    
    //Variablen
    Enemy target;
    PVector targetDir;
    String[] effects;
    
    public Player(ProjectileManager pm){
        this.pm = pm;
    }
    
    public void shoot() {
        //if abfrage ob random wert in crit bereich fällt und erhöhten schaden übergeben
        pm.addPlayerProjectile(targetDir, damage, effects);
    }
    
}
