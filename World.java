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
        gridSize = 50;

        loadWorld();
    }

    public void login(View view, Model model){
        this.view = view;
    }

    public void update(){
        Block b = blocks.remove(0);
        b.update();
        blocks.add(b);
    }

    public void show(){
        Block b = blocks.remove(0);
        b.show();
        blocks.add(b);
    }

    public void loadWorld(){
        // for(int i = 0; i < 3; i++){
           for(int j = 0; j < 1; j++){
                blocks.add(new Block(new PVector(0,j), gridSize, view));
           }
        // }
    }
}
