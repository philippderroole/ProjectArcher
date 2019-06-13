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

    public void login(Player player, World world, EnemyManager enemyManager, ProjectileManager projectileManager){
        this.player = player;
        this.world = world;
        this.enemyManager = enemyManager;
        this.projectileManager = projectileManager;
    }

    public void show(){
        pApplet.background(255);

        world.show();
        player.show();
        enemyManager.show();
        projectileManager.show();
        //ellipse(new PVector(200, 300), 120, 60, 45);

    }

    public void ellipse(PVector pos, float dx, float dy, float rotation) {
        pApplet.pushMatrix();
        pApplet.translate(pos.x, pos.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        pApplet.ellipse(0, 0, dx, dy);
        pApplet.popMatrix();
    }

    public void ellipse(PVector pos, float dx, float dy, float rotation, int[] color) {
        pApplet.pushMatrix();
        pApplet.translate(pos.x, pos.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        if (color.length == 3) {
            pApplet.fill(color[0], color[1], color[2]);
        }
        if (color.length == 4) {
            pApplet.fill(color[0], color[1], color[2], color[3]);
        }
        pApplet.ellipse(0, 0, dx, dy);
        pApplet.fill(255);
        pApplet.popMatrix();
    }

    public void rect(PVector position, float width, float height,float rotation) {
        pApplet.pushMatrix();
        pApplet.translate(position.x, position.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        pApplet.rect(0, 0, width, height);
        pApplet.popMatrix();
    }

    public int getWidth() {
        return pApplet.width;
    }

    public int getHeight() {
        return pApplet.height;
    }
}
