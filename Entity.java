import processing.core.*;

public abstract class Entity extends Element{
    
    //Klassen zum Anmelden

    
    //Variablen
    float health;
    float damage;
    float attackspeed;
    float movespeed;
    
    public Entity(){

    }
    
    public void update(){
        
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
    
    public float getMovespeed(){
        return movespeed;
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
    
    public void setMovespeed(float movespeed){
        this.movespeed = movespeed;
    }
}
