import processing.core.PImage;

public class shark {
       float sharkX, sharkY; // Shark's position
    float speed = 3; // Movement speed
    float sharkSize= 73;//size of shark
    PImage shark;

          // Variables to store shark's direction of movement
          float sharkXDirection = 0;
          float sharkYDirection = 0;


    public void setup(){
        // Load the shark image
        shark = loadImage("shark.png");

}
}