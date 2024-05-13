package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game.GameWindow.direction;

public class KeyAdapter implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) { // Not used

    }

    @Override
    public void keyPressed(KeyEvent e) { // set the direction of the snake
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                if(direction != 'R')
                {
                    GameWindow.setDirection('L');
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(direction != 'L')
                {
                    GameWindow.setDirection('R');
                }
                break;
            case KeyEvent.VK_UP:
                if(direction != 'D')
                {
                    GameWindow.setDirection('U');
                }
                break;
            case KeyEvent.VK_DOWN:
                if(direction != 'U')
                {
                    GameWindow.setDirection('D');
                }
                break;
            default:
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) { // Not used

    }
}
