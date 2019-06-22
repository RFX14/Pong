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
    static JFrame frame = new JFrame("Pong! -Settings");
    volatile static boolean close = false;
    static Color color = new Color(255, 255, 255);

    public Settings() {
        setLayout(null);
        JColorChooser colorChooser = new JColorChooser();
        ColorSelectionModel model = colorChooser.getSelectionModel();
        ChangeListener changeListener = new ChangeListener(){
        
            @Override
            public void stateChanged(ChangeEvent e) {
                color = colorChooser.getColor();
            }
        };
        JButton play = new JButton("PLAY!");
        play.setLocation(Main.getXFrame()/2 - 75, Main.getYFrame()/2 - 25);
        play.setSize(150, 50);
        play.addActionListener(this);
        add(play);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Sprites sprites = new Sprites();
        sprites.printText("Color?", Main.getXFrame() - 120, Main.getYFrame()/8, g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if(btn.equalsIgnoreCase("play!")) {
            close = true;
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
        frame.setVisible(true);
        frame.add(new Settings());
    }
}