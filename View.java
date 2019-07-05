import processing.core.*;

public class View{
    //Klassen zum Anmelden
    PApplet pApplet;
    Load loader;
    Controller controller;
    Player player;
    World world;
    EnemyManager enemyManager;
    ProjectileManager projectileManager;
    ItemManager itemManager;

    //variables
    float gridSize;
    //images
    PImage playerImg;
    PImage field;
    PImage block;
    PImage water;
    PImage spider;
    PImage playerProjectile;
    PImage enemyProjectile;
    PImage healthPotion;

    public View(){

    }
    
    public void setup() {
        playerImg = pApplet.loadImage("assets/player.png");
        field = pApplet.loadImage("assets/field_3.png");
        block = pApplet.loadImage("assets/block.png");
        water = pApplet.loadImage("assets/water_2.png");
        spider = pApplet.loadImage("assets/enemy_spider.png");
        playerProjectile = pApplet.loadImage("assets/projectile.png");
        enemyProjectile = pApplet.loadImage("assets/projectile_enemy.png");
        healthPotion = pApplet.loadImage("assets/potion_hp.png");
    }

    public void login(Load loader, Controller controller, PApplet pApplet){
        this.loader = loader;
        this.controller = controller;
        this.pApplet = pApplet;

    }

    public void login(Player player, World world, EnemyManager enemyManager, ProjectileManager projectileManager, ItemManager itemManager, float gridSize){
        this.player = player;
        this.world = world;
        this.enemyManager = enemyManager;
        this.projectileManager = projectileManager;
        this.itemManager = itemManager;
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
        projectileManager.show();
        player.show();
        enemyManager.show();
        itemManager.show();
        
        
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

    public void image(String s, PVector position, float rotation) {
        pApplet.pushMatrix();
        pApplet.translate(position.x + gridSize/2, position.y + gridSize/2);
        pApplet.rotate((float) ((rotation * Math.PI) / 180));
        pApplet.translate(- gridSize/2, - gridSize/2);
        switch (s) {
            case "block":
            pApplet.image(block, 0,0);
            break;
            case "water":
            pApplet.image(water, 0,0);
            break;
            case "spider":
            pApplet.image(spider, 0,0);
            break;
            case "playerProjectile":
            pApplet.image(playerProjectile, 0,0);
            break;
            case "enemyProjectile":
            pApplet.image(enemyProjectile, 0,0);
            break;
            case "player":
            pApplet.image(playerImg, 0,0);
            break;
            case "healthPotion":
            pApplet.image(healthPotion, 0,0);
            break;
        }

        pApplet.popMatrix();
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
