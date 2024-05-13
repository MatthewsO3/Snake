package game;

import javax.swing.*;

import java.awt.*;

public class BaseFrame extends JFrame {
    public static int getSpeed() {
        return speed;
    } // getter and setter for speed and body length

    public static void setSpeed(int speed) {
        BaseFrame.speed = speed;
    }

    public static int getBody() {
        return body;
    }

    public static void setBody(int body) {
        BaseFrame.body = body;
    }

    private static int body=6;//initial body length
    private static int speed = 200; // timer speed
    
    static Dimension expectedDimension = new Dimension(665, 713); // expected dimension of the frame
    BaseFrame() {
        super("Snake");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem startItem = new JMenuItem("Restart Game");
        startItem.addActionListener(e -> { dispose(); GameWindow gameFrame = new GameWindow(); gameFrame.setVisible(true); });
        JMenuItem mainmenu = new JMenuItem("Main Menu");
        mainmenu.addActionListener(e -> { dispose(); Frame mainFrame = new Frame(); mainFrame.setVisible(true); });

        JMenuItem optionsItem = new JMenuItem("Options");
        optionsItem.addActionListener(e -> showOptionsDialog());
        JMenuItem pauseItem = new JMenuItem("Pause");
        JMenuItem resumeItem = new JMenuItem("Resume");
        pauseItem.addActionListener(e -> GameWindow.timer.stop());
        resumeItem.addActionListener(e -> GameWindow.timer.start());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(mainmenu);
        fileMenu.add(startItem);
        fileMenu.add(resumeItem);
        fileMenu.add(pauseItem);

        fileMenu.add(optionsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add the file menu to the menu bar
        menuBar.add(fileMenu);
        // Set the menu bar for the frame
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(expectedDimension);
        this.setSize(expectedDimension);
        this.getContentPane().setPreferredSize(expectedDimension);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void showOptionsDialog() { // options dialog
        String speedInput = JOptionPane.showInputDialog(this, "Enter timer speed (milliseconds):\nThe bigger the number is the slower the snake is.\nRecommended value: 200");
        String bodyInput = JOptionPane.showInputDialog(this, "Enter initial body length:\nRecommended value: 6");
        try {
            int inputspeed = Integer.parseInt(speedInput);
            int bodyL = Integer.parseInt(bodyInput);
            if (inputspeed > 0) {
                setSpeed(inputspeed);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for the timer speed.");
            }
            if(bodyL > 0) {
                setBody(bodyL);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for the initial body length.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid positive integer for the timer speed.");
        }
    }
}
