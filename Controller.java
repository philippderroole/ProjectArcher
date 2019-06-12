import processing.core.*;

public class Controller{
    
    //Klassen zum Anmelden
    PApplet pApplet;
    View view;
    Model model;
    
    //Variablen
    Player player;
    World world;
    EnemyManager enemyManager;
    ProjectileManager projectileManager;
    
    public Controller(){
        player = new Player(projectileManager);
        world = new World();
        enemyManager = new EnemyManager();
        projectileManager = new ProjectileManager();
        
        
        view.login(player, world, enemyManager, projectileManager);
        player.login(pApplet);
        world.login(pApplet, model);
        enemyManager.login(pApplet);
        projectileManager.login(pApplet);
    }
    
    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;
    }
    
    public void setup(){
        pApplet.frameRate(30);
    }
    
    public void draw(){
        pApplet.background(255);
        
        player.move(5);
        
        //update
        player.update();
        world.update();
        enemyManager.update();
        projectileManager.update();
        
        view.show();
    }
}
