import processing.core.*;
import java.util.*;

public class World{
    //Klassen zum Anmelden
    View view;

    //Variablen
    private ArrayList<Block> blocks;
    private float gridSize;

    public World(){
        blocks = new ArrayList<Block>();

    }

    public void login(View view, Model model){
        this.view = view;
    }

    public void setup() {
        gridSize = view.getWidth() / 20;
        loadWorld();
    }
    
    public void update(){
        for(Block b : blocks) {
            b.update();
        }
    }

    public void show(){
        for(Block b : blocks) {
            b.show();
        }
    }

    public void loadWorld(){
        System.out.println("world " + view);
        // for(int y = 0; y < 3; y++){
        for(int x = 0; x < 15; x++){
            blocks.add(new Block(new PVector(x,0), gridSize, view));
        }
        // }
    }
}
