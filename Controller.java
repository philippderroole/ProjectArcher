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
        player = new Player();
        world = new World();
        enemyManager = new EnemyManager();
    }

    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;

        //view.login(player, world, enemyManager, projectileManager);
        player.login(view, projectileManager);
        world.login(view, model);
        enemyManager.login(pApplet);
        projectileManager.login(pApplet);
    }

    public void setup(){
        pApplet.frameRate(30);
        world.setup();
        
    }

    public void draw(){
        player.move(new PVector(1,1));

        //update
        
        world.update();
        enemyManager.update();
        projectileManager.update();
        player.update();

        view.show();
        player.show();
        world.show();
        enemyManager.show();
        projectileManager.show();

    }
}
