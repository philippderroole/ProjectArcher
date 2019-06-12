import processing.core.*;
import java.util.*;

public class EnemyManager{
    //Klassen zum Anmelden
    PApplet pApplet;
    
    //Variablen
    private ArrayList<Enemy> enemies;

    public EnemyManager(){
        enemies = new ArrayList<Enemy>();
    }
    
    public void login(PApplet pApplet){
        this.pApplet = pApplet;
    }

    public void update(){
        enemies.forEach((e) -> e.update());
    }

    public void show(){
        enemies.forEach((e) -> e.show());
    }
    
    public ArrayList getEnemies() {
        return enemies;
    }
}
