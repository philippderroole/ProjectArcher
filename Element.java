import processing.core.*;

public abstract class Element{
    
    //Klassen zum Anmelden
    private PApplet pApplet;
    
    //Variablen
    private PVector position;
    private float rotation;
    
    public Element(){
        position = new PVector(0,0);
        rotation = 0;
    }
    
    public void login(PApplet pApplet){
        this.pApplet = pApplet;
    }
    
    public void update(){
        
    }
    
    public void show(){
        pApplet.pushMatrix();
        pApplet.ellipse(position.x, position.y, 50, 50);
        pApplet.translate(position.x, position.y);
        pApplet.rotate(rotation);
        pApplet.popMatrix();
    }
    
    public void rotate(){
        
    }
    
    public void look(float angle){ //default right
        if(angle < 360 && angle > 0){
            setRotation(angle);
        } else {
            setRotation(0);
        }
    }
    
    public void move(float distance){
        
    }
    
    //getter und setter Methoden
    
    public PVector getPosition(){
        return position;
    }
    
    public float getRotation(){
        return rotation;
    }
    
    public void setPosition(PVector position){
        this.position = position;
    }
    
    public void setRotation(float rotation){
        this.rotation = rotation;
    }
}
