import processing.core.*;

public class Controller{
    
    //Klassen zum Anmelden
    PApplet pApplet;
    View view;
    Model model;
    
    //Variablen
    Player p;
    World w;
    EnemyManager em;
    ProjectileManager pm;
    
    public Controller(){
    }
    
    public void login(PApplet pApplet, View view, Model model){
        this.pApplet = pApplet;
        this.view = view;
        this.model = model;
    }
    
    public void setup(){
        p = new Player(pm);
        p.login(pApplet);
    }
    
    public void draw(){
        pApplet.background(255);
        p.show();
    }
}
