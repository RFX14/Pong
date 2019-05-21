import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
    Main main;
    int xPos = 0;
    int yPos = 0;

    int xVel = 2;
    int yVel = -2;

    public Ball() {
        main = new Main();
        xPos = main.getXFrame() / 2;
        yPos = main.getYFrame() / 2;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(xPos, yPos, 20, 20);
    }

    public void update(Player player1) {
        //Ball Physics Reaaallly basic
        if(yPos == 0) {
            yVel = Math.abs(yVel);
        }
        if(yPos == main.getYFrame() - 46) {
            yVel = -yVel;
        }

        if(xPos <= 35 && xPos >= 20 && yPos > player1.getY() && yPos < player1.getY() + 70) {
            xVel = Math.abs(xVel);
        }
        if(xPos == main.getXFrame() - 45) {
            xVel = -xVel;
        }

        xPos += xVel;
        yPos += yVel;
    }
}