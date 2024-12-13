import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    ArrayList<shark> sharks;
    int windowX = 600;
    int windowY = 600;

    fish fish1;

    int score = 0; // Variable to track the score

    int scene = 0;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        fish1 = new fish(275, 587, this);
        sharks = new ArrayList<>();
  

        int startY = 50;
        for (int i = 0; i < 3; i++) {
            sharks.add(new shark(600, startY, 1, this));
            startY += 180;
        }
        startY = 100;
        for (int i = 0; i < 3; i++) {
            sharks.add(new shark(600, startY, -1, this));
            startY += 180;
        }
    
        // Set up text size for score display
        textSize(32);
        fill(255); // White text for the score

    }

    public void settings() {
        size(windowX, windowY);

    }

    public void draw() {
        background(143, 191, 229);
        for (shark s : sharks) {
            s.display();
            s.move();
        }

        shark alliTestShark = sharks.get(0);
        if(alliTestShark.eats(fish1)){
            System.out.println("oh nooo!");
        }

        fish1.display();
        textSize(25);
        fill(25);

        // keep shark to move angles

        // // Display the score

        fill(255); // Set text color to white
        text("Score: " + score, 10, 40); // Draw score at top-left corner

        // // Check if shark catches the fish
        

        
            // score++;
         // Increase score when circle is caught
        // }

        // }else if(scene == 2){

        // background(255,0,0);

        // fill(50);
        // text("DEAD! \n Press space to respawn", 50, 300);

        // }
        // //RETRUN TO LAST SCENE
        // public void keyPressed() {
        // if (key == ' ') {
        // scene = 1;
        // }

    }

    public void keyPressed() {

        if (keyCode == UP) {
            fish1.goUp();
        }
        if (keyCode == LEFT) {
            fish1.goLeft();

        }
        if (keyCode == RIGHT) {
            fish1.goRight();
        }

    }
}
