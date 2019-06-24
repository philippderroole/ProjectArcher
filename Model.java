import processing.core.*;
import java.io.*;

public class Model{

    File levelFile;

    View view;
    Controller controller;

    public Model(){

    }

    public void login(View view, Controller controller){
        this.view = view;
        this.controller = controller;
    }

    public String[][] getLevel(int level) {
        String[][] answer = new String[20][20];
        int i = 0;

        levelFile = new File("level" + level + ".txt");
        if (levelFile == null) {
            System.out.println("GEWONNEN!");
            return null;
        }

        try {
            BufferedReader fileReader = new BufferedReader( new FileReader(levelFile));
            String line = "";
            while((line = fileReader.readLine()) != null) {
                String[] split = line.split(";");
                answer[i] = split;
                i++;
            } 
        }catch (Exception e) {

        }

        System.out.println();

        for (int j = 0; j < 15; j++) {
            for (int k= 0; k < 20; k ++) {
                System.out.print(answer[j][k]);
            }
            System.out.println();
        }
        return answer;
    }
}
