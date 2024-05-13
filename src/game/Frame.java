package game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


import java.io.IOException;


import static game.ImageReader.readImage;


public class Frame extends BaseFrame implements java.awt.event.ActionListener {

    JButton play = new JButton("Play");
    private static String playerName;
    static JTextField name = new JTextField( 10);
    JButton players = new JButton("Scoreboard");
    JButton exit = new JButton("Exit");



    public void initComponents() { // initialize the components
        JPanel menuPanel;
        try {
            this.setBackground(new Color(136,168,5));
            this.setContentPane(new JLabel(new ImageIcon(readImage("background.jpg"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       menuPanel =  createMenuPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(menuPanel, gbc);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);

    }

    Frame(){
        this.initComponents();
        this.setVisible(true);
        BaseFrame.setBody(6);
        BaseFrame.setSpeed(200);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // action listener for the buttons
        if (e.getSource().equals(play))
        {
            dispose();
            GameWindow gameFrame = new GameWindow();
            gameFrame.setVisible(true);
        }
        else if (e.getSource().equals(players))
        {
            String playerInfo = PlayerList.getPlayersDescendingOrder(PlayerList.players);
            JOptionPane.showMessageDialog(null, playerInfo, "Players and Scores", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource().equals(name))
        {
            setName();
        }
        else
        {
            System.exit(0);
        }
    }


    private JPanel createMenuPanel() { // menu panel
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBackground(new Color(136,168,5));
        Dimension buttonSize = new Dimension(50, 50);
        JLabel textArea = new JLabel("Enter your name then hit Enter");
        Font font = new Font("Ink Free",Font.BOLD,30);

        textArea.setFont(new Font("Ink Free",Font.BOLD,20));
        textArea.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        textArea.setHorizontalTextPosition(SwingConstants.CENTER);
        textArea.setVerticalTextPosition(SwingConstants.CENTER);

        play.setBackground(new Color(136,168,5));
        play.setFont(font);
        play.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        play.setPreferredSize(buttonSize);
        play.setMinimumSize(buttonSize);
        play.setMaximumSize(buttonSize);
        play.setFocusPainted(false);
        play.addActionListener(this);

        players.setMaximumSize(buttonSize);
        players.setBackground(new Color(136,168,5));
        players.setFont(font);
        players.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        players.setFocusPainted(false);
        players.addActionListener(this);

        exit.setMaximumSize(buttonSize);
        exit.setBackground(new Color(136,168,5));
        exit.setFont(font);
        exit.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        exit.setFocusPainted(false);
        exit.addActionListener(this);

        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setMaximumSize(buttonSize);
        name.setFont(font);
        name.setBackground(new Color(136,168,5));
        name.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        name.addActionListener(this);

        panel.add(textArea);
        panel.add(name);
        panel.add(play);
        panel.add(players);
        panel.add(exit);
        return panel;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setName()
    {
        playerName = name.getText();
    }

}