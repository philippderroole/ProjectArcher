import processing.core.*;
import java.util.*;

public class Main extends PApplet{
    private PApplet pApplet;
    private Load loader;
    private View view;
    private Controller controller;

    public Main(){ //läuft als erstes
        pApplet = this;
        loader = new Loader();
        view = new View();
        controller = new Controller();

        login();
    }

    public static void main(String args[]){ 
        PApplet.main("Main"); //startet PApplet und ruft Main() auf
    }

    public void settings(){ //läuft als zweites
        size(64*20,64*15);
        // fullScreen();
    }

    public void setup(){ //läuft als drittes
        controller.setup();
    }

    public void draw(){
        // println(frameRate);
        controller.draw();
    }
    
    public void keyPressed(){
        controller.keyPressed();
    }
    
    public void keyReleased(){
        controller.keyReleased();
    }

    public void login() {
        loader.login(view, controller);
        view.login(loader, controller, pApplet);
        controller.login(pApplet, view, loader);
    }
}