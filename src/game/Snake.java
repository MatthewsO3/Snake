package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static game.ImageReader.readImage;


public class Snake extends GameWindow {

    private static final BufferedImage UheadIcon;
    private static final BufferedImage DheadIcon;
    private static final BufferedImage LheadIcon;
    private static final BufferedImage RheadIcon;
    private static final BufferedImage bodyIcon;
    private static final BufferedImage UpIcon;
    private static final BufferedImage LRIcon;
    private static final BufferedImage RLIcon;
    private static final BufferedImage ULIcon;
    private static final BufferedImage URIcon;
   static char[] movement = new char[gameUnits];
   static int mov_size = 6;

    static {
        try {
             UheadIcon = readImage("u_head.png");
             DheadIcon = readImage("d_head.png");
             LheadIcon = readImage("l_head.png");
             RheadIcon = readImage("head.png");
             bodyIcon = readImage("body.png");
             UpIcon = readImage("up.png");
             LRIcon = readImage("lr.png");
             RLIcon = readImage("rl.png");
             ULIcon = readImage("ul.png");
             URIcon = readImage("ur.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public static void draw(Graphics g) { // draw the snake
        int i;
        for (i = 0; i < getBody(); i++) {
            if (i == 0) { // head
                switch (GameWindow.getDirection())
                {
                    case 'U':
                        g.drawImage(UheadIcon, cord_x[i], cord_y[i], null);
                        break;
                    case 'D':
                        g.drawImage(DheadIcon, cord_x[i], cord_y[i], null);
                        break;
                    case 'L':
                        g.drawImage(LheadIcon, cord_x[i], cord_y[i], null);
                        break;
                    case 'R':
                        g.drawImage(RheadIcon, cord_x[i], cord_y[i], null);
                        break;
                    default:
                        break;
                }
            } else { // body
                if (i < mov_size) {
                    char prevMove = movement[i - 1];
                    char currentMove = movement[i];
                    BufferedImage turnIcon = null;

                    // Kép kiválasztása a kanyarodás irányától függően
                    if (prevMove == 'U' && currentMove == 'R' || prevMove == 'L' && currentMove == 'D') { //
                        turnIcon = ULIcon;
                    } else if (prevMove == 'R' && currentMove == 'D' || prevMove == 'U' && currentMove == 'L') {
                        turnIcon = URIcon;
                    } else if (prevMove == 'D' && currentMove == 'L' || prevMove == 'R' && currentMove == 'U') {
                        turnIcon = LRIcon;
                    } else if (prevMove == 'D' && currentMove == 'R' || prevMove == 'L' && currentMove == 'U') {
                        turnIcon = RLIcon;
                    } else if (cord_x[i - 1] == cord_x[i + 1] && cord_x[i] == cord_x[i - 1]) {
                        turnIcon = UpIcon;
                    }

                    if (turnIcon != null) {
                        g.drawImage(turnIcon, cord_x[i], cord_y[i], null);
                    } else {
                        g.drawImage(bodyIcon, cord_x[i], cord_y[i], null);
                    }
                } else {
                    g.drawImage(bodyIcon, cord_x[i], cord_y[i], null);
                }
            }

        }
    }

    public static void appleEaten() // increase the body of the snake if it eats an apple
    {
        if((cord_x[0] == appleX) && (cord_y[0] == appleY))
        {
            increaseBody(1);
            apple = false;
            applesEaten++;
            mov_size++;
        }
    }
    public static void move() { // move the snake
        for (int i = GameWindow.getBody() ; i > 0; i--) {
            cord_x[i] = cord_x[i-1];
            cord_y[i] = cord_y[i-1];
            movement[i] = movement[i - 1];

        }

        switch (direction) {
            case 'L' -> {
                cord_x[0] -= unitSize;
                movement[0] = 'L';
            }
            case 'R' -> {
                cord_x[0] += unitSize;
                movement[0] = 'R';
            }
            case 'U' -> {
                cord_y[0] -= unitSize;
                movement[0] = 'U';
            }
            case 'D' -> {
                cord_y[0] += unitSize;
                movement[0] = 'D';
            }
            default -> {
            }
        }
    }
    public static void checkForCollison() {// Check for collision with body or borders
        for (int i = GameWindow.getBody(); i > 0; i--) {
            if ((cord_x[0] == cord_x[i]) && (cord_y[0] == cord_y[i])) { // check for collision with body
                running = false;
                break;
            }
        }

        if (cord_x[0] < 0 || cord_x[0] >= screenWidth || cord_y[0] < 0 || cord_y[0] >= screenHeight) {// check for collision with borders
            running = false;
        }

        if (!running) {
            timer.stop();

        }
    }

    public static void bananaEaten() { // increase the body of the snake by two if it eats a banana
        if((cord_x[0] == bananaX) && (cord_y[0] == bananaY))
        {
            increaseBody(2);
            banana= false;
            bananasEaten++;
            mov_size= mov_size+2;
        }

    }
}


