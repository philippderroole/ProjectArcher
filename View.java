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

    //variables
    float gridSize;
    //images
    PImage field;
    PImage block;
    PImage water;
    PImage spider;

    public View(){

    }
    
    public void setup() {
        field = pApplet.loadImage("assets/field_3.png");
        block = pApplet.loadImage("assets/block.png");
        water = pApplet.loadImage("assets/water_2.png");
        spider = pApplet.loadImage("assets/enemy_spider.png");
    }

    public void login(Model model, Controller controller, PApplet pApplet){
        this.model = model;
        this.controller = controller;
        this.pApplet = pApplet;

    }

    public void login(Player player, World world, EnemyManager enemyManager, ProjectileManager projectileManager, float gridSize){
        this.player = player;
        this.world = world;
        this.enemyManager = enemyManager;
        this.projectileManager = projectileManager;
        this.gridSize = gridSize;
    }

    public void show(){
        pApplet.background(255);
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 20; x++) {
                pApplet.image(field, x * gridSize, y * gridSize);
            }
        }

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

    public void rect(PVector position, float width, float height,float rotation, int[] color) {
        pApplet.pushMatrix();
        pApplet.translate(position.x, position.y);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        if (color.length == 3) {
            pApplet.fill(color[0], color[1], color[2]);
        }
        if (color.length == 4) {
            pApplet.fill(color[0], color[1], color[2], color[3]);
        }
        pApplet.rect(0, 0, width, height);
        pApplet.popMatrix();
    }

    public void text(String s, float posX, float posY, int size, int[] color) {
        pApplet.stroke(3);
        pApplet.fill(color[0], color[1], color[2]);
        pApplet.textAlign(pApplet.CENTER, pApplet.CENTER);
        pApplet.textSize(size);
        pApplet.text(s, posX, posY);
    }

    public void image(String s, PVector position) {
        switch (s) {
            case "block":
            pApplet.image(block, position.x, position.y);
            break;
            case "water":
            pApplet.image(water, position.x, position.y);
            break;
            case "spider":
            pApplet.image(spider, position.x, position.y);
            break;
        }

    }

    public int getWidth() {
        return pApplet.width;
    }

    public int getHeight() {
        return pApplet.height;
    }
    
    public float getGridSize() {
        return gridSize;
    }
}
