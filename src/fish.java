import processing.core.PApplet;
import processing.core.PImage;

public class fish {

    float fishX, fishY; // Fish's position
    float speed = 11; // Movement speed
    float fishSize = 50;// size of fish
    PImage fish;
    PApplet canvas;

    // Variables to store Fish's direction of movement
    float fishXDirection;
    float fishYDirection;

    public fish(float x, float y, PApplet c) {
        canvas = c;
        fish = canvas.loadImage("fish.png");
        fishX = x;
        fishY = y;

    }
//display fish
    public void display() {
        canvas.image(fish, fishX, fishY, fishSize, fishSize);

    }
//reset when first reaches top
    public void goUp() {
        fishY -= speed;
        // if (fishY <= 0) 
        // reset();
        
        
    }
    


    public void goLeft() {
        fishX -= speed;
    }

    public void goRight() {
        fishX += speed;
    }

    public float getX() {
        return fishX;
    }

    public float getY() {
        return fishY;
    }
//reset fish to the middle of bottom screen when needed
    public void reset() {
        fishX = 275;
        fishY = 587;

    }
}