package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements Runnable, ActionListener {
    Ball ball;
    Player player;
    Player2 player2;
    Score score;
    Timer gamelooptimer;
    static JFrame frame = new JFrame("Pong!");

    public Game() {
        setLayout(null);
        player = new Player();
        player2 = new Player2();
        score = new Score();
        ball = new Ball();

        //gamelooptimer is what sets everything into motion
        setFocusable(true);
        gamelooptimer = new Timer(10, this);
        gamelooptimer.start();
        
        //This actually gets the computer to focus on this and take key inputs
        addKeyListener(new KeyInput(player, player2));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Main.getXFrame(), Main.getYFrame());

        player.draw(g2d);
        player2.draw(g2d);
        ball.draw(g2d);
        score.draw(g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void actionPerformed(ActionEvent e) {
        player.update();
        player2.update();
        ball.update(player, player2);
        score.update(ball);
        repaint();
    }

    public void run() {
        frame.pack();
        frame.setResizable(false);
        frame.setSize(Main.getXFrame(), Main.getYFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
    }
}
