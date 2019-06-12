import processing.core.*;
import java.util.*;

public class World{
    //Klassen zum Anmelden
    PApplet pApplet;

    //Variablen
    private ArrayList<Block> blocks;
    private float gridSize;

    public World(){
        blocks = new ArrayList<Block>();
        gridSize = 50;

        loadWorld();
    }

    public void login(PApplet pApplet, Model model){
        this.pApplet = pApplet;
    }

    public void update(){
        blocks.forEach((u) -> u.show());
    }

    public void show(){
        blocks.forEach((b) -> b.show());
    }

    public void loadWorld(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 20; j++){
                blocks.add(new Block(new PVector(j,i), gridSize));
            }
        }
    }
}
