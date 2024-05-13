package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Random;

import static game.GameWindow.*;
import static game.ImageReader.readImage;

public class Fruit {

    private static BufferedImage Aimage; // image for the apple
    private static BufferedImage Bimage; // image for the banana
    static Random rand = new Random();
    static {
        try {
            Aimage = readImage("apple.jpg");
            Bimage = readImage("banana.jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void genFruit() // generate fruit at random coordinates
    {
        boolean XYatSnake = true;
        while(XYatSnake){
        if(!apple) {

            appleX = (rand.nextInt(screenWidth / unitSize))*unitSize;
            appleY = (rand.nextInt(screenHeight/ unitSize))*unitSize;
            apple = true;
        }
        if(!banana)
        {
            bananaX = (rand.nextInt(screenWidth / unitSize))*unitSize;
            bananaY = (rand.nextInt(screenHeight/ unitSize))*unitSize;
            banana = true;
        }
        XYatSnake = false;
        for(int i=0 ; i<getBody(); i++)
        {
            if(appleX == cord_x[i] && appleY == cord_y[i])
            {
                XYatSnake = true;
                apple = false;
                break;
            }
            else if(bananaX == cord_x[i] && bananaY == cord_y[i])
            {
                XYatSnake = true;
                banana = false;
                break;
            }
        }
        }

    }

    public static void draw(Graphics g) { // draw the fruit
        g.drawImage(Aimage, appleX, appleY, null);
        g.drawImage(Bimage, bananaX, bananaY, null);
    }
}