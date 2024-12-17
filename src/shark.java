import processing.core.PApplet;
import processing.core.PImage;

public class shark {
    float sharkX, sharkY; // Shark's position
    float speed = 3; // Movement speed
    float sharkSize = 73;// size of shark

    PImage shark;
    PApplet canvas;

    // Variables to store shark's direction of movement
    float sharkXDirection;
    float sharkYDirection;

    public shark(float x, float y, float xDirection, PApplet c) {
        canvas = c;
        shark = canvas.loadImage("shark.png");
        sharkX = x;
        sharkY = y;
        sharkXDirection = xDirection;

        // Mr. Moden: constructor
        // Mr. Moden: set up values here
    }

    public void display() {
        canvas.image(shark, sharkX, sharkY, sharkSize, sharkSize);
    }

    public void move() {
        sharkX += speed * sharkXDirection;
        if (sharkX >= canvas.width) {
            sharkX = 5;
        }

        if (sharkX < 0) {
            sharkX = 600;
        }
        // if (sharkX = 600){
        // speed=-speed;
        // }
    }

    public boolean eats(fish toBeEaten) {
        if (canvas.dist(sharkX + sharkSize / 2, sharkY + sharkSize / 2, toBeEaten.getX(), toBeEaten.getY()) < 25 ) {
            System.out.println("eaten!");
            return true;
        
        }else{
            return false;
        }

    }

    // <
    // SharkSize / 2 + fishSize / 2);

    // public void setup(){
    // Load the shark image
    // shark = loadImage("shark.png");

    // // from chatgpt
    // Draw the shark with rotation
    // pushMatrix(); // Save the current transformation state
    // translate(sharkX + sharkSize / 2, sharkY + sharkSize / 2); // Move the origin
    // to the center of the shark
    // rotate(angle); // Rotate the shark to face the direction
    // imageMode(CENTER); // Ensure the image is drawn from its center
    // image(shark, 0, 0, sharkSize, sharkSize); // Draw the shark at the translated
    // position
    // popMatrix(); // Restore the previous transformation state

    // }
}