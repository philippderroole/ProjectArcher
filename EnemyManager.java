import processing.core.*;
import java.util.*;

public class EnemyManager{
    //Klassen zum Anmelden
    View view;
    ProjectileManager projectileManager;
    
    //Variablen
    private ArrayList<Enemy> enemies;
    private float gridSize;

    public EnemyManager(float gridSize){
        enemies = new ArrayList<Enemy>();
        this.gridSize = gridSize;
    }
    
    public void login(View view, ProjectileManager projectileManager){
        this.view = view;
        this.projectileManager = projectileManager;
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
        for(int y = 0; y < 15; y++){
            for(int x = 0; x < 20; x++){
                if (level[y][x].compareTo("s") == 0) {
                    enemies.add(new Shooter(new PVector((float)(x+0.5) * gridSize , (float) (y+0.5) * gridSize), view, gridSize));
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
        PVector direction = nearestEnemyPosition.sub(playerPosition);
        return direction.normalize();
    }
    
    public void checkEnemyDamage(){
        for(Enemy e : enemies) {
            projectileManager.getEnemyDamage(e.position.copy(), e.getSize());
        }
    }
    
    public boolean isEnemy(){
        if(enemies.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
