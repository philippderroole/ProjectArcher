import processing.core.*;

public abstract class Enemy extends Element{

    protected float health;
    protected float maxHealth;
    
    protected float size;
    protected ProjectileManager projectileManager;

    protected float maxDelay;
    protected float currentDelay;
    protected PVector targetDirection;

    protected float damage;
    
    protected float moveSpeed;
    protected PVector moveDir;
    

    public Enemy(){
    }
    public void attack(PVector pos) {
    }
    
    public void show(){
        view.rect(position, 50, 50, 0);
        showHealthbar();
    }
    
    public void showHealthbar() {
        //leben
        int[] color = {100,100,100};
        view.rect(new PVector(position.x-50, position.y-75), 100, 12, 0, color);
        color = new int[] {200,130,130};
        int length = (int) (health/maxHealth * 100);
        view.rect(new PVector(position.x-50, position.y-75), length, 12, 0, color);
        // color = new int[] {0, 0, 0};
        // view.text(String.valueOf((int) health), position.x+2, position.y - 78, 20, color);
        // color = new int[] {255, 255, 255};
        // view.text(String.valueOf((int) health), position.x, position.y - 80, 20, color);
    }
    
    public void correctPosition(PVector direction){
        position.add(direction.copy());
    }

    public void getDamage(float damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }
    
    public float getSize(){
        return size;
    }
    
    public float getHealth() {
        return health;
    }
}
