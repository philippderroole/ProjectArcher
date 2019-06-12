import processing.core.*;
import java.util.*;

public abstract class Element{

    //Klassen zum Anmelden
    protected View view;

    //Variablen
    protected PVector position;
    protected float rotation;

    public Element(){
        position = new PVector(0,0);
        rotation = 0;
    }

    public void login(View view){
        this.view = view;
    }

    public void update(){
        
    }

    public void look(float angle){ //default right
        if(angle < 360 && angle > 0){
            setRotation(angle);
        } else {
            setRotation(0);
        }
    }

    public void move(PVector direction){
        position.x += direction.x;
        position.y += direction.y;
    }
    
    public float random(float max){
        return (float) Math.random() * max;
    }
    
    public float random(float min, float max){
        return (float) Math.random() * (max - min) - min;
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
