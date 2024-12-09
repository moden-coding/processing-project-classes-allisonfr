import processing.core.PApplet;
import processing.core.PImage;

public class shark {
       float sharkX, sharkY; // Shark's position
        float speed = 3; // Movement speed
        float sharkSize= 73;//size of shark
        PImage shark;
        PApplet canvas;

            // Variables to store shark's direction of movement
        float sharkXDirection = 0;
        float sharkYDirection = 0;
        public shark(PApplet c){
            canvas = c;
            shark = canvas.loadImage("shark.png");


        //Mr. Moden: constructor
        //Mr. Moden: set up values here
    }

    public void display(){
        canvas.image(shark, sharkX, sharkSize);
    }

    public void setup(){
        // Load the shark image
        // shark = loadImage("shark.png");

        //  // from chatgpt
        //     // Draw the shark with rotation
        //     pushMatrix(); // Save the current transformation state
        //     translate(sharkX + sharkSize / 2, sharkY + sharkSize / 2); // Move the origin to the center of the shark
        //     rotate(angle); // Rotate the shark to face the direction
        //     imageMode(CENTER); // Ensure the image is drawn from its center
        //     image(shark, 0, 0, sharkSize, sharkSize); // Draw the shark at the translated position
        //     popMatrix(); // Restore the previous transformation state

}
}