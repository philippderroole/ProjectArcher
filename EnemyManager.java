import processing.core.*;
import java.util.*;

public class EnemyManager{
    //Klassen zum Anmelden
    View view;
    
    //Variablen
    private ArrayList<Enemy> enemies;
    private float gridSize;

    public EnemyManager(){
        enemies = new ArrayList<Enemy>();
    }
    
    public void login(View view){
        this.view = view;
    }

    public void update(){
        for(Enemy e : enemies) {
            e.update();
        }
    }

    public void show(){
        for(Enemy e : enemies) {
            e.show();
        }
    }
    
    public void loadEnemies(String[][] level){
        gridSize = view.getWidth() / 20;
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                if (level[y][x].compareTo("s") == 0) {
                    enemies.add(new Shooter(new PVector(x * gridSize, y * gridSize), view));
                }
            }
        }
    }
    
    public ArrayList getEnemies() {
        return enemies;
    }
    
    public PVector getNearestEnemyDirection(PVector playerPosition){
        PVector nearestEnemyPosition = new PVector();
        float minDistance = (float) Math.pow(2,31);
        float aktDistance;
        for(Enemy e: enemies) {
            aktDistance = PVector.dist(playerPosition, e.getPosition());
            if(aktDistance < minDistance){
                minDistance = aktDistance;
                nearestEnemyPosition = e.getPosition();
            }
        }
        PVector direction = playerPosition.sub(nearestEnemyPosition);
        return direction.normalize();
    }
    
    public boolean isEnemy(){
        if(enemies.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
