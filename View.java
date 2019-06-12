import processing.core.*;

public class View{
    //Klassen zum Anmelden
    Model model;
    Controller controller;
    Player player;
    World world;
    EnemyManager enemyManager;
    ProjectileManager projectileManager;
    
    public View(){

    }
    
    public void login(Model model, Controller controller){
        this.model = model;
        this.controller = controller;
    }
    
    public void login(Player player, World world, EnemyManager enemyManager, ProjectileManager projectileManager){
        this.player = player;
        this.world = world;
        this.enemyManager = enemyManager;
        this.projectileManager = projectileManager;
    }
    
    public void show(){
        player.show();
        world.show();
        enemyManager.show();
        projectileManager.show();
    }
}
