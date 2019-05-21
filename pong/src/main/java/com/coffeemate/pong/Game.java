import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
    Main main;
    Ball ball;
    Player player;
    Score score;
    Timer gamelooptimer;

    public Game() {
        main = new Main();
        player = new Player();
        score = new Score();
        ball = new Ball();

        //gamelooptimer is what sets everything into motion
        setFocusable(true);
        gamelooptimer = new Timer(10, this);
        gamelooptimer.start();
        
        //This actually gets the computer to focus on this and take key inputs
        addKeyListener(new KeyInput(player));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, main.getXFrame(), main.getYFrame());

        player.draw(g2d);
        ball.draw(g2d);
        score.draw(g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        score.update();
        player.update();
        ball.update(player);
        repaint();
    }

}
