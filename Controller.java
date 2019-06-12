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
        projectileManager = new ProjectileManager();
        player = new Player(projectileManager);
        world = new World();
        enemyManager = new EnemyManager();
    }
    
    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;
        
        view.login(player, world, enemyManager, projectileManager);
        player.login(pApplet);
        world.login(pApplet, model);
        enemyManager.login(pApplet);
        projectileManager.login(pApplet);
    }
    
    public void setup(){
        pApplet.frameRate(30);
        world.loadWorld();
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
