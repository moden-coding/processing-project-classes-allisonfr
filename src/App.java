import processing.core.*;

public class App extends PApplet{
    int windowX = 600;
    int windowY = 600;
    
    PImage shark;
PImage fish;
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
        
          
            //  // Check if shark catches the fish
            //     if (dist(sharkX + sharkSize / 2, sharkY + sharkSize / 2, circleX, circleY) < sharkSize / 2 + circleSize / 2) {
               
           
                    score++; // Increase score when circle is caught
                }

       
    //     }else if(scene == 2){

    //         background(255,0,0);
           
    //      fill(50);
    //         text("DEAD! \n Press space to respawn", 50, 300);
   
    //     }
    //         //RETRUN TO LAST SCENE
    // public void keyPressed() {
    //     if (key == ' ') {
    //         scene = 1;
    // }

    }
}
