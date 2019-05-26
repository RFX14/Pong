import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
    Main main;
    Score score;
    int xPos = 0;
    int yPos = 0;

    int xVel = 2;
    int yVel = -2;

    boolean goal1;
    boolean goal2;

    public Ball() {
        main = new Main();
        score = new Score();
        goal1 = false;
        goal2 = false;
        xPos = main.getXFrame() / 2;
        yPos = main.getYFrame() / 2;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(xPos, yPos, 20, 20);
    }

    public void update(Player player1, Player2 player2) {
        //Ball Physics against walls Reaaallly basic
        if(yPos == 0) {
            yVel = Math.abs(yVel);
        }
        if(yPos == main.getYFrame() - 46) {
            yVel = -yVel;
        }

        //Paddle 1 Interaction
        if(xPos < 35 && xPos > 20 && yPos > player1.getY() && yPos < player1.getY() + 70) {
            xVel = Math.abs(xVel);
        }

        //Paddle 2 Interaction
        if(xPos < 600 && xPos > 585 && yPos > player2.getY() && yPos < player2.getY() + 70) {
            xVel = -xVel;
        }

        //Player1 gets a point
        if(xPos == 620) {
            goal1 = true;
            xVel = -xVel;
        }

        //Player2 gets a point
        if(xPos == 0) {
            goal2 = true;
            xVel = Math.abs(xVel);
        }

        xPos += xVel;
        yPos += yVel;
    }

    public boolean getGoal1() {
        return goal1;
    }

    public boolean getGoal2() {
        return goal2;
    }

    public void setGoal1(boolean goal) {
        this.goal1 = goal;
    }

    public void setGoal2(boolean goal) {
        this.goal2 = goal;
    }
}