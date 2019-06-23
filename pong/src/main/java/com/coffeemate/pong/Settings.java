import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends JPanel implements Runnable, ActionListener {
    static JFrame frame = new JFrame("Pong!");
    volatile static boolean close = false;
    static Color color = Color.WHITE;

    public Settings() {
        setLayout(null);
        setBackground(Color.BLACK);
        JButton play = new JButton("PLAY!");
        JButton btnColor = new JButton("PADDLE COLOR");

        play.setLocation(Main.getXFrame()/2 - 75, Main.getYFrame()/2 - 25);
        btnColor.setLocation(Main.getXFrame()/2 - 75, Main.getYFrame()/2 + 75);

        play.setSize(150, 50);
        btnColor.setSize(150, 50);

        play.addActionListener(this);
        btnColor.addActionListener(this);
        add(play);
        add(btnColor);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Sprites sprites = new Sprites();
        sprites.printText("Settings", Main.getXFrame() - 570, Main.getYFrame()/8, g2d);

        g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        g2d.fillRect(Main.getXFrame()/2 + 75, Main.getYFrame()/2 + 80, 45, 40);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if(btn.equalsIgnoreCase("play!")) {
            close = true;
            Settings.frame.dispose();
            Thread t2 = new Thread(new Game()); 
            t2.start();          
        } else if(btn.equalsIgnoreCase("paddle color")) {
            color = JColorChooser.showDialog(null, "Paddle Color", Color.WHITE);
            System.out.println(color);
            repaint();
        }
    }

    public static boolean getClose() {
		return close;
    }

    @Override
    public void run() {
        frame.pack();
        frame.setResizable(false);
        frame.setSize(Main.getXFrame(), Main.getYFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.setVisible(true);
        frame.add(new Settings());
    }
}