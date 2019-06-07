import processing.core.*;

public class Controller{
    
    //Klassen zum Anmelden
    PApplet pApplet;
    
    //Variablen
    Player p;
    
    public Controller(){
        p = new Player();
    }
    
    public void login(PApplet pApplet){
        this.pApplet = pApplet;
    }
    
    public void setup(){
        p.login(pApplet);
    }
    
    public void draw(){
        pApplet.background(255);
        p.show();
    }
}
