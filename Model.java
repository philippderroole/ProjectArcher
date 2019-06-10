import processing.core.*;

public class Model{

    View view;
    Controller controller;
    
    public Model(){
        
    }
    
    public void login(View view, Controller controller){
        this.view = view;
        this.controller = controller;
    }
}
