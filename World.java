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

    public void setup(String[][] level) {
        gridSize = view.getWidth() / 20;
        loadWorld(level);
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

    public void loadWorld(String[][] level){
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                if (level[y][x].compareTo("1") == 0) {
                    blocks.add(new Block(new PVector(x,y), gridSize, view));
                }
            }
        }
    }
    
    public PVector checkCollision(PVector position, float size){
        // blocks.get(2).intersects(position.copy(), size);
        for(Block b : blocks) {
            return b.intersectsPlayer(position.copy(), size);
        }
        return null;
    }
}
