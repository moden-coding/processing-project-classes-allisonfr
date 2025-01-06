import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import processing.core.*;

public class App extends PApplet {
    ArrayList<shark> sharks;
    int windowX = 600;
    int windowY = 600;

    fish fish1;

    int lives = 3; // Variable to track the score

    int scene = 0;
    int highScore;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {

        ReadHighScore();

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

        // Set up text size for live display
        textSize(32);
        fill(255); // White text for the live

    }

    public void settings() {
        size(windowX, windowY);

    }

    public void draw() {
        background(143, 191, 229);

        boolean collisiondectector = false;
        // // Check if fish reached the top
        // if (fishY <= 0) {
        // lives++; // increase lives by one
        // fish1.reset(); // Reset fish position
        // ReadHighScore();
        if (scene == 0) {
            for (shark s : sharks) {
                s.display();
                s.move();
                if (s.eats(fish1)) {
                    fish1.reset();
                    lives--;
                    if (lives <= 0) {
                        scene = 1;
                        if(highScore < lives)
                        saveHighScore();
                    }

                }
            }

            fish1.display();
            if (fish1.getY() <= 0) {
                scene = 1;
                saveHighScore();
            }
            text("Lives: " + lives, 10, 40); // Display the lives

            textSize(25);
            fill(25);

        } else if (scene == 1){

            background(255, 140, 75);

            fill(50);
            text( "Press space to respawn!! \nYou finished with " + lives + " lives left", 50, 300);

            // RETRUN TO LAST SCENE

        }
    }

    // control fish direction
    public void ReadHighScore() {
        try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                highScore = Integer.valueOf(row);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
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

        if (key == ' ') {
            scene = 0;
            lives = 3;

        }

    }

    public void saveHighScore() {

        try (PrintWriter writer = new PrintWriter("highscore.txt")) {
            writer.println(highScore); // Writes the integer to the file
            writer.close(); // Closes the writer and saves the file
            System.out.println("Integer saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
