import processing.core.*;
import java.util.*;

public class Controller{

    // Klassen zum Anmelden
    PApplet pApplet;
    View view;
    Model model;

    // Variablen
    private int currentLevel;
    private Player player;
    private World world;
    private float gridSize;
    private EnemyManager enemyManager;
    private ProjectileManager projectileManager;
    private ArrayList<String> pressedKeys;

    public Controller(){
        
        gridSize = 64;
        currentLevel = 1;
        projectileManager = new ProjectileManager();
        player = new Player(gridSize);
        world = new World(gridSize);
        enemyManager = new EnemyManager(gridSize);
        pressedKeys = new ArrayList<String>();
    }

    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;

        view.login(player, world, enemyManager, projectileManager, gridSize);
        player.login(view, projectileManager, enemyManager);
        world.login(view, projectileManager);
        enemyManager.login(view, projectileManager);
        projectileManager.login(view);
    }

    public void setup(){
        pApplet.frameRate(30);
        
        String[][] level = model.getLevel(currentLevel);
        currentLevel++;
        
        world.setup(level);
        enemyManager.loadEnemies(level);
        
        view.setup();
        
    }
    
    public void nextLevel() {
        String[][] level = model.getLevel(currentLevel);
        currentLevel++;
        
        world.setup(level);
        enemyManager.loadEnemies(level);
    }

    public void draw(){
        checkDirection();

        // System.out.println(checkDirection().x + " " + checkDirection().y);
        player.move(checkDirection());
        // world.checkCollision(player.getPosition().copy(), player.getSize());
        player.correctPosition(world.getIntersection(player.getPosition().copy(), player.getSize()));
        player.getDamage(projectileManager.getPlayerDamage(player.getPosition().copy(), player.getSize()));
        world.checkBlockProjectileIntersection(); //moomentan nur block-Projectile
        enemyManager.checkEnemyDamage();
        enemyManager.shoot(player.getPosition());        
        
        //update
        
        world.update();
        enemyManager.update();
        projectileManager.update();
        player.update();

        view.show();
       
        // System.out.println(pressedKeys);
    }
    
    public void keyPressed(){
        if(!pressedKeys.contains("" + pApplet.keyCode)){        
            pressedKeys.add("" + pApplet.keyCode);
        }
    }
    
    public void keyReleased(){
        pressedKeys.remove("" + pApplet.keyCode);
    }
    
    public PVector checkDirection(){
        PVector direction = new PVector(0,0);
        
        if(pressedKeys.contains("" + 37)){ //links
            direction.add(-1, 0);
        }
        if(pressedKeys.contains("" + 38)){ //oben            
            direction.add(0, -1);
        }
        if(pressedKeys.contains("" + 39)){ //rechts
            direction.add(1, 0);
        }
        if(pressedKeys.contains("" + 40)){ //unten
            direction.add(0, 1);
        }
        if(pressedKeys.contains("" + 65)){ //links
            direction.add(-1, 0);
        }
        if(pressedKeys.contains("" + 87)){ //oben            
            direction.add(0, -1);
        }
        if(pressedKeys.contains("" + 68)){ //rechts
            direction.add(1, 0);
        }
        if(pressedKeys.contains("" + 83)){ //unten
            direction.add(0, 1);
        }
        return direction.normalize();
    }
}
