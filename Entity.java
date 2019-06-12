import processing.core.*;

public abstract class Entity extends Element{
    
    //Klassen zum Anmelden

    
    //Variablen
    protected float maxHealth;
    protected float health;
    protected float damage;
    protected float attackspeed;
    protected float currentDelay;

    
    public Entity(){

    }

    //getter und setter Methoden
    public float getHealth(){
        return health;
    }
    
    public float getDamage(){
        return damage;
    }
    
    public float getAttackspeed(){
        return attackspeed;
    }
    
    public void setHealth(float health){
        this.health = health;
    }
    
    public void setDamage(float damage){
        this.damage = damage;
    }
    
    public void setAttackspeed(float attackspeed){
        this.attackspeed = attackspeed;
    }
}
