import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player {
    int xPos = 20;
    int yPos = 10;
    int yVel = 0;

    public Player() {
        yPos = (Main.getYFrame() / 2) - 70;
    }

    public void update() {
        //Sets map bounds
        if(yPos < 0) {
            yPos += Math.abs(yPos);
        } else if(yPos > Main.getYFrame() - 90) {
            yPos += (Main.getYFrame() - 90) - yPos;
        }

        yPos += yVel;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
                yVel = -5;
                
            } else if(key == KeyEvent.VK_S) {
                yVel = 5;
            }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            yVel = 0;
        } else if(key == KeyEvent.VK_S) {
            yVel = 0;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Settings.color);
        g2d.fillRect(xPos, yPos, 15, 70);
    }

    public int getX() {
        return xPos + 15;
    }

    public int getY() {
        return yPos;
    }
}