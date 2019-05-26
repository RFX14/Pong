import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {
    Main main;
    int scoreOne;
    int scoreTwo;

    public Score() {
        main = new Main();
        scoreOne = 0;
        scoreTwo = 0;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("OCR A Std", Font.BOLD, 72));
        g2d.drawString(Integer.toString(scoreOne), main.getXFrame() / 4, 80);

        g2d.drawString(Integer.toString(scoreTwo), main.getXFrame() *  3/4, 80);
    }

    public void update(Ball ball) {
        if(ball.getGoal1()) {
            scoreOne++;
            ball.setGoal1(false);
        }

        if(ball.getGoal2()) {
            scoreTwo++;
            ball.setGoal2(false);
        }
        System.out.println("\nPlayer1: " + scoreOne);
        System.out.println("Player2: " + scoreTwo);
    }
}