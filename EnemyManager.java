import processing.core.*;
import java.util.*;

public class EnemyManager{
    //Klassen zum Anmelden
    View view;
    World world;
    ProjectileManager projectileManager;

    //Variablen
    private ArrayList<Enemy> enemies;
    private float gridSize;

    public EnemyManager(float gridSize){
        enemies = new ArrayList<Enemy>();
        this.gridSize = gridSize;
    }

    public void login(View view, ProjectileManager projectileManager, World world){
        this.view = view;
        this.projectileManager = projectileManager;
        this.world = world;
    }

    public void update(){
        for(Enemy e : enemies) {
            e.update();
            
            e.correctPosition(world.getIntersectionVector(e.getPosition().copy(), e.getSize()));
        }
    }

    public void attack(PVector pos){
        for(Enemy e : enemies) {
            e.attack(pos.copy());
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
                    enemies.add(new Shooter(new PVector((float)(x+0.5) * gridSize , (float) (y+0.5) * gridSize), 
                    view, projectileManager, gridSize));
                } else if (level[y][x].compareTo("m") == 0) {
                    enemies.add(new Mover(new PVector((float)(x+0.5) * gridSize , (float) (y+0.5) * gridSize), 
                    view, projectileManager, gridSize));
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

    public void checkIsEnemyHit(){
        for(int i = enemies.size() - 1; i >= 0; i--) {
            Enemy e = enemies.get(i);

            e.getDamage(projectileManager.getEnemyDamage(e.position.copy(), e.getSize()));
            if (e.getHealth() <= 0) {
                enemies.remove(e);
            }
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
