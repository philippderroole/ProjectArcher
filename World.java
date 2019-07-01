import processing.core.*;
import java.util.*;

public class World{
    //Klassen zum Anmelden
    View view;
    ProjectileManager projectileManager;

    //Variablen
    private ArrayList<Obstacle> obstacles;
    private float gridSize;
    
    
    

    public World(float gridSize){
        obstacles = new ArrayList<Obstacle>();
        
        
    
        this.gridSize = gridSize;
    }

    public void login(View view, ProjectileManager projectileManager){
        this.view = view;
        this.projectileManager = projectileManager;
    }

    public void setup(String[][] level) {
        // gridSize = view.getWidth() / 20;
        loadWorld(level);
    }

    public void update(){
        for(Obstacle b : obstacles) {
            b.update();
        }
    }

    public void show(){
        for(Obstacle b : obstacles) {
            b.show();
        }
    }

    public void loadWorld(String[][] level){
        for(int y = 0; y < 15; y++){
            for(int x = 0; x < 20; x++){
                if (level[y][x].compareTo("1") == 0) {
                    obstacles.add(new Block(new PVector(x,y), "block", gridSize, view));
                }
                if (level[y][x].compareTo("w") == 0) {
                    obstacles.add(new Water(new PVector(x,y), "water", gridSize, view));
                }
            }
        }
    }
    
    public void clearWorld() {
        obstacles = new ArrayList<Obstacle>();

    }  
    
    public PVector getIntersectionVector(PVector position, float size){
        // blocks.get(2).intersects(position.copy(), size);
        PVector p = new PVector();
        for(Obstacle b : obstacles) {
            p.add(b.correctIntersectsCircle(position.copy(), size));
        }
        return p;
    }
    
    public void checkBlockProjectileIntersection(){
        for(Obstacle b : obstacles) {
            projectileManager.checkBlocks(b);
        }
    }
}
