package game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GameWindow extends BaseFrame implements ActionListener {
    static final int screenWidth = 650; //width of the map
    static final int screenHeight = 650; //height of the map
    static final int unitSize = 25; // one square size
    static final int gameUnits = (screenWidth * (screenHeight)) / unitSize; // number of squares

    public static void increaseBody(int body) {
        GameWindow.body += body;
    } // increase body length


    public static int getBody() {
        return body;
    }



    private static int body; // body length
    static final int[] cord_x = new int[gameUnits]; // x coordinates of the snake
    static final int[] cord_y = new int[gameUnits]; // y coordinates of the snake



    static int applesEaten=0; // number of apples eaten
    static int bananasEaten=0; // number of bananas eaten
    static int appleX; // x coordinate of the apple
    static int appleY; // y coordinate of the apple
    static boolean apple = false; // is there an apple on the map
    static boolean banana = false; // is there a banana on the map
    static int bananaX; // x coordinate of the banana
    static int bananaY; //  y coordinate of the banana

    public static void setDirection(Character direction) {
        GameWindow.direction = direction;
    }

    public static Character getDirection() {
        return direction;
    }

    static Character direction = 'U'; // direction of the snake

    static boolean running = true; // is the game running
    private GamePanel gamePanel;
    static Timer timer; // timer for the game
    public void initComponents() // initialize the components
    {

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyAdapter());

        // Create a JPanel for custom painting
        gamePanel = new GamePanel();
        this.add(gamePanel);
        // Trigger the initial repaint
        repaint();


    }
    GameWindow()
    {

        super();
        resetGame();
        timer= new Timer(getSpeed(),this);
        GameWindow.body = BaseFrame.getBody();
        timer.start();
        this.initComponents();
        this.setVisible(true);

    }
    public void drawGame(Graphics g) //draws the game
    {
        Fruit.genFruit();
        g.setColor(Color.GREEN);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score:" +(applesEaten + bananasEaten*2), metrics.stringWidth("Score")-90,metrics.getHeight()-10);

    }@Override


    public void actionPerformed(ActionEvent e) { // action listener for the timer

        if(running)
        {
            Snake.move();
            Snake.checkForCollison();
            Snake.appleEaten();
            Snake.bananaEaten();
        }
        if(!running)
        {
            dispose();
            GameOver gameover;
            try {
                gameover = new GameOver();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            gameover.setVisible(true);
            String name = Frame.getPlayerName();
            int score = applesEaten + bananasEaten*2;
            PlayerList.addPlayer(name,score);
        }
        else
        {
            gamePanel.repaint();
        }

    }
    public static void resetGame() { // reset the game
        applesEaten = 0;
        bananasEaten = 0;
        body = BaseFrame.getBody();
        Snake.movement = new char[gameUnits];
        Snake.mov_size = BaseFrame.getBody();
        direction = 'U';
        running = true;

        for (int i = 0; i < body; i++) {
            cord_x[i] = screenWidth / 2;
            cord_y[i] = screenHeight / 2;
        }
        Fruit.genFruit();
    }

    private class GamePanel extends JPanel { // panel for the game
        @Override
        protected void paintComponent(Graphics g) {
            this.setPreferredSize(new Dimension(650, 650));
            this.setMaximumSize(new Dimension(650, 650));
            this.setMinimumSize(new Dimension(650, 650));
            this.setBackground(new Color(136, 168, 5));
            super.paintComponent(g);
            drawGame(g);
            Snake.draw(g);
            Fruit.draw(g);
        }
    }

}
