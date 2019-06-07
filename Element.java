import processing.core.*;

public abstract class Element{
    
    //Klassen zum Anmelden
    private View view;
    
    //Variablen
    private PVector pos;
    
    public Element(){

    }
    
    public void login(View view){
        this.view = view;
    }
    
    public void update(){
        
    }
    
    public void show(){
        
    }
    
    public void rotate(){
    
    }
}
