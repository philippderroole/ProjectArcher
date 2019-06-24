import processing.core.*;

public abstract class Enemy extends Element{

    protected float size;
    protected ProjectileManager projectileManager;

    protected float maxDelay;
    protected float currentDelay;
    protected PVector targetDirection;

    protected float damage;

    public Enemy(){
    }
    public void shoot(PVector pos) {
    }
    
    public void show(){
        view.rect(position, 50, 50, 0);
    }

    public float getSize(){
        return size;
    }
}
