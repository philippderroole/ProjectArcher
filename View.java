import processing.core.*;

public class View{
    //Klassen zum Anmelden
    PApplet pApplet;
    Model model;
    Controller controller;
    Player player;
    World world;
    EnemyManager enemyManager;
    ProjectileManager projectileManager;
    
    public View(){

    }
    
    public void login(Model model, Controller controller, PApplet pApplet){
        this.model = model;
        this.controller = controller;
        this.pApplet = pApplet;
    }
    
    // public void login(Player player, World world, EnemyManager enemyManager, ProjectileManager projectileManager){
        // this.player = player;
        // this.world = world;
        // this.enemyManager = enemyManager;
        // this.projectileManager = projectileManager;
    // }
    
    public void show(){
        pApplet.background(255);
        
        ellipse(new PVector(200, 300), 120, 60, 45);
        
    }
    
    public void ellipse(PVector pos, float dx, float dy, float rotation) {
        pApplet.pushMatrix();
        pApplet.translate(pos.x, pos.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        pApplet.ellipse(0, 0, dx, dy);
        pApplet.popMatrix();
    }
    
    public void rect(PVector pos, float dx, float dy, float rotation) {
        pApplet.pushMatrix();
        pApplet.translate(pos.x, pos.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        pApplet.rect(0, 0, dx, dy);
        pApplet.popMatrix();
    }
}
