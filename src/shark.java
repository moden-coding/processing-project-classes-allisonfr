import processing.core.PApplet;
import processing.core.PImage;

public class shark {
    float sharkX, sharkY; // Shark's position
    float speed = 6; // Movement speed
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
     
 
    }
 boolean firstcollision = false;
 
   
    public boolean eats(fish toBeEaten) {
        if (canvas.dist(sharkX + sharkSize / 2, sharkY + sharkSize / 2, toBeEaten.getX(), toBeEaten.getY()) < 25 ) {
            return true;
            // if(!firstcollision){
            //     return true;
            // }
            // firstcollision=true;
        
        }else{
            return false;
        }

    }

}