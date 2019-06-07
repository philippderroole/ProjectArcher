import processing.core.*;

public class Main extends PApplet{
    private PApplet pApplet;
    private Model model;
    private View view;
    private Controller controller;
    
    public Main(){ // läuft als erstes
        pApplet = this;
        model = new Model();
        view = new View();
        controller = new Controller();
        
        login();
    }
    
    public static void main(String args[]){ 
        PApplet.main("Main"); //startet PApplet und ruft Main() auf
    }
        
    public void settings(){ // läuft als zweites
        size(500,500);
    }
    
    public void setup(){ // läuft als drittes
        controller.setup();
    }
    
    public void draw(){
        controller.draw();
    }
    
    public void login() {
        model.login();
        view.login();
        controller.login(pApplet);
    }
}