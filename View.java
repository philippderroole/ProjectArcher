import processing.core.*;

public class View{

    Model model;
    Controller controller;
    
    public View(){

    }
    
    public void login(Model model, Controller controller){
        this.model = model;
        this.controller = controller;
    }
}
