import processing.core.*;

public class App extends PApplet{
    int windowX = 600;
    int windowY = 600;
    float sharkX, sharkY; // Shark's position
    float speed = 3; // Movement speed
    float sharkSize= 73;//size of shark
    PImage shark;
    PImage fish;
    int circleSize;
    int circleX;
    int circleY;
    
      // Variables to store shark's direction of movement
      float sharkXDirection = 0;
      float sharkYDirection = 0;
      int score = 0; // Variable to track the score

      int scene = 0;

    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
          // Load the shark image
          shark = loadImage("shark.png");
                  //load fish image
        fish = loadImage("fish.png");
         // Set up text size for score display
         textSize(32);
         fill(255); // White text for the score
     
    }

    public void settings(){
        size(windowX, windowY);
        
    }

    public void draw(){
            if(scene == 0){
                background(143, 191, 229); // Set background to blue
                text("Press space to begin and use \n your arrow keys to move the shark!", 50, 300);// add rules
            }else if(scene == 1){
                background(143, 191, 229); // Set background to blue
    
                // Display the score
        
                fill(255); // Set text color to white
                text("Score: " + score, 10, 40); // Draw score at top-left corner
        
          
        
                // Check if shark catches the fish
                if (dist(sharkX + sharkSize / 2, sharkY + sharkSize / 2, circleX, circleY) < sharkSize / 2 + circleSize / 2) {
               
                    score++; // Increase score when circle is caught
                }
  // Draw the fish
  image(fish, circleX, circleY, circleSize, circleSize);
        // from chatgpt
            // Draw the shark with rotation
            pushMatrix(); // Save the current transformation state
            translate(sharkX + sharkSize / 2, sharkY + sharkSize / 2); // Move the origin to the center of the shark
            rotate(angle); // Rotate the shark to face the direction
            imageMode(CENTER); // Ensure the image is drawn from its center
            image(shark, 0, 0, sharkSize, sharkSize); // Draw the shark at the translated position
            popMatrix(); // Restore the previous transformation state
        }else if(scene == 2){

            background(255,0,0);
           
         fill(50);
            text("DEAD! \n Press space to respawn", 50, 300);
   
        }
            //RETRUN TO LAST SCENE
    public void keyPressed() {
        if (key == ' ') {
            scene = 1;
    }

    }
}
