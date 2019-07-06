import processing.core.*;
import java.util.*;

public class Controller{

    //test

    // Klassen zum Anmelden
    PApplet pApplet;
    View view;
    Load loader;

    // Variablen
    private int currentLevel;
    private Player player;
    private World world;
    private float gridSize;
    private EnemyManager enemyManager;
    private ProjectileManager projectileManager;
    private ItemManager itemManager;
    private ArrayList<String> pressedKeys;

    public Controller(){
        gridSize = 64;
        currentLevel = 1;

        projectileManager = new ProjectileManager();
        player = new Player(gridSize);
        world = new World(gridSize);
        enemyManager = new EnemyManager(gridSize);
        itemManager = new ItemManager(gridSize);
        pressedKeys = new ArrayList<String>();
    }

    public void restart() {

    }

    public void login(PApplet pApplet, View view, Load loader){
        this.pApplet = pApplet;
        this.view = view;
        this.loader = loader;

        view.login(player, world, enemyManager, projectileManager, itemManager, gridSize);
        player.login(view, projectileManager, enemyManager);
        world.login(view, projectileManager);
        enemyManager.login(view, projectileManager, world, itemManager);
        projectileManager.login(view);
        itemManager.login(view);
    }

    public void setup(){
        pApplet.frameRate(30);

        currentLevel = 1;
        String[][] level = loader.getLevel(currentLevel);
        currentLevel++;

        world.setup(level);
        enemyManager.loadEnemies(level);

        view.setup();

    }

    public void nextLevel() {
        String[][] level = loader.getLevel(currentLevel);
        currentLevel++;

        if (level[0][0] == null) {
            currentLevel = 1;  
            level = loader.getLevel(currentLevel);
        }

        world.clearWorld();
        world.setup(level);
        enemyManager.clearEnemies();
        enemyManager.loadEnemies(level);
        projectileManager.killProjectiles();
        itemManager.clearItems();

        player.setPosition(new PVector(100,960/2));
    }

    public void draw(){
        player.move(getInputDirection());
        // world.checkCollision(player.getPosition().copy(), player.getSize());

        PVector moveBackVector = world.getIntersectionVector(player.getPosition().copy(), player.getSize());
        player.correctPosition(moveBackVector);

        float projectileDamage = projectileManager.calculatePlayerDamage(player.getPosition().copy(), player.getSize());
        player.takeDamage(projectileDamage);

        world.checkBlockProjectileIntersection();

        enemyManager.checkIsEnemyHit();
        enemyManager.attack(player.getPosition().copy());
        float collisionDamage = enemyManager.calculateCollisionDamage(player.getPosition(), player.getSize());
        player.takeDamage(collisionDamage);
        
        //heal
        float healthRestore = itemManager.checkPlayerCollision(player.getPosition(), player.getSize());
        player.heal(healthRestore);
        //update
        world.update();
        enemyManager.update();
        projectileManager.update();
        itemManager.update();
        player.update();
        

        view.show();

        // check player death
        if (player.isDead()) {
            reset();
        }
        //check if player has won
        if (!enemyManager.isEnemy()) {
            nextLevel();
        }
    }

    public void reset() {
        // player = null;

        // setup();
    }

    public void keyPressed(){
        if(!pressedKeys.contains("" + pApplet.keyCode)){        
            pressedKeys.add("" + pApplet.keyCode);
        }

        //cheats
        if(pressedKeys.contains("" + 521)){ //plus
            nextLevel();
            pressedKeys.remove("" + pApplet.keyCode);
        }
        if(pressedKeys.contains("" + 45)){ //minus
            currentLevel -= 2;
            nextLevel();
            pressedKeys.remove("" + pApplet.keyCode);
        }
        if(pressedKeys.contains("" + 82)){ //reset
            currentLevel -= 1;
            nextLevel();
            pressedKeys.remove("" + pApplet.keyCode);
        }
    }

    public void keyReleased(){
        pressedKeys.remove("" + pApplet.keyCode);
    }

    public PVector getInputDirection(){
        PVector direction = new PVector(0,0);
        System.out.println(pressedKeys);
        //arrowkeys
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

        //wasd
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

        //System.out.println(direction.x + " " + direction.y);
        return direction.copy().normalize();
    }
}
