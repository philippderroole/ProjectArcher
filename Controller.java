import processing.core.*;
import java.util.*;

public class Controller{

    //Klassen zum Anmelden
    PApplet pApplet;
    View view;
    Model model;

    //Variablen
    private Player player;
    private World world;
    private EnemyManager enemyManager;
    private ProjectileManager projectileManager;
    private ArrayList<String> pressedKeys;

    public Controller(){
        projectileManager = new ProjectileManager();
        player = new Player(projectileManager);
        world = new World();
        enemyManager = new EnemyManager();
        pressedKeys = new ArrayList<String>();
    }

    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;

        //view.login(player, world, enemyManager, projectileManager);
        player.login(view);
        world.login(view, model);
        enemyManager.login(pApplet);
        projectileManager.login(pApplet);
    }

    public void setup(){
        pApplet.frameRate(30);
        world.setup();
    }

    public void draw(){
        checkDirection();
        System.out.println(checkDirection().x + " " + checkDirection().y);
        player.move(5);

        //update
        player.update();
        world.update();
        enemyManager.update();
        projectileManager.update();

        view.show();
        player.show();
        world.show();
        enemyManager.show();
        projectileManager.show();

    }
    
    public void keyPressed(){
        if(pressedKeys.contains("" + pApplet.keyCode)){
        
        } else {
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
            direction.add(0, 1);
        }
        if(pressedKeys.contains("" + 39)){ //rechts
            direction.add(1, 0);
        }
        if(pressedKeys.contains("" + 40)){ //unten
            direction.add(0, -1);
        }
        return direction;
    }
}
