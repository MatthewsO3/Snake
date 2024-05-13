package game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static game.ImageReader.readImage;

public class GameOver extends BaseFrame{
    public void initComponents() throws IOException { // initialize the components
        setContentPane(new JLabel(new ImageIcon(readImage("gameover.jpg"))));
        setBackground(Color.black);
        this.setPreferredSize(expectedDimension);
    }
    GameOver() throws IOException {
        this.initComponents();
        this.setVisible(true);
    }
}
