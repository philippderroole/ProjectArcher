import processing.core.*;

public class Projectile extends Element{

    //Variablen
    float damage;
    String[] effects; //noch nicht klar wie genau alle effekte verwaltet werden

    public Projectile(){

    }
    
    public void show(){
        view.ellipse(position, 50, 50, 0);
    }
}
