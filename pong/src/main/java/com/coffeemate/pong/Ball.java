import java.awt.Color;
import java.awt.Graphics2D;
/**
 * TODO: Get more accurate physics collisions with the ball
 */

public class Ball {
    Score score;
    int xPos = 0;
    int yPos = 0;

    int xVel = 2;
    int yVel = -2;

    int xAcl = 0;
    int yAcl = 0;

    boolean goal1;
    boolean goal2;

    public Ball() {
        score = new Score();
        goal1 = false;
        goal2 = false;
        xPos = Main.getXFrame() / 2;
        yPos = Main.getYFrame() / 2;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(xPos, yPos, 20, 20);
    }

    public void update(Player player1, Player2 player2) {
        SoundManager sound = new SoundManager();
        //Ball Physics against walls Reaaallly basic
        if(yPos <= 0) {
            yAcl++;
            yVel = Math.abs(yVel);
            sound.play(false, true);
        }
        if(yPos >= Main.getYFrame() - 46) {
            yAcl = -(yAcl + 1);
            yVel = -yVel;
            sound.play(false, true);
        }

        //Paddle 1 Interaction
        if(xPos <= 35 && xPos >= 20 && yPos > player1.getY() && yPos < player1.getY() + 70) {
            xAcl = -xAcl + 1;
            xVel = Math.abs(xVel);
            sound.play(false, true);
        }

        //Paddle 2 Interaction
        if(xPos <= 600 && xPos >= 585 && yPos > player2.getY() && yPos < player2.getY() + 70) {
            xAcl = -(xAcl + 1);
            xVel = -xVel;
            sound.play(false, true);
        }

        //Player1 gets a point
        if(xPos >= 620) {
            goal1 = true;
            xPos = Main.getXFrame() / 2;
            yPos = Main.getYFrame() / 2;
            sound.play(true, false);
        }

        //Player2 gets a point
        if(xPos <= 0) {
            goal2 = true;
            xPos = Main.getXFrame() / 2;
            yPos = Main.getYFrame() / 2;
            sound.play(true, false);
        }

        //Resets all ball properties when there's a goal
        if(goal1 || goal2) {
            xVel = (int) (Math.random() * 2) + 1;
            yVel = (int) (Math.random() * 2);
            xAcl = 0;
            yAcl = 0;
        }

        xPos += (xVel + xAcl);
        yPos += (yVel + yAcl);

        //System.out.println("\nxVel: " + xVel);
        //System.out.println("xAcl: " + xAcl);
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