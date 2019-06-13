import processing.core.*;

public abstract class Projectile extends Element{

    //Variablen
    float damage;
    String[] effects; //noch nicht klar wie genau alle effekte verwaltet werden

    public Projectile(){
        damage = 100;
    }
    
    public void show(){
        view.ellipse(position, 50, 50, 0);
    }
    
    public float intersectsPlayer(PVector position, float size){
        return 0;
    }
    
    public float intersectsEnemy(PVector position, float size){
        return 0;
    }
}
