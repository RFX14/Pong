package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements Runnable, ActionListener {
    static int xSize = 640;
    static int ySize = 480;
    int x = xSize / 16;
    int y = ySize / 2 - 60;
    volatile static String next = "";
    static JFrame frame = new JFrame("Pong!");

    public Menu() {
        setLayout(null);
        setBackground(Color.BLACK);
        xSize = 640;
        ySize = 480;

        JButton play = new JButton("PLAY!");
        play.setLocation(xSize / 2 - 75, ySize / 2 - 25);
        play.setSize(150, 50);
        play.addActionListener(this);
        add(play);

        JButton settings = new JButton("SETTINGS");
        settings.setLocation(xSize / 2 - 75, ySize / 2 + 50);
        settings.setSize(150, 50);
        settings.addActionListener(this);
        add(settings);
    }

    public int getXFrame() {
        return xSize;
    }

    public int getYFrame() {
        return ySize;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Sprites sprites = new Sprites();
        sprites.printText("PONG", xSize/2 - 120, ySize/8, g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if(btn.equalsIgnoreCase("play!")) {
            next = "game";
        } else if(btn.equalsIgnoreCase("settings")) {
            next = "settings";
        }
    }

	public void run() {
		frame.pack();
        frame.setResizable(false);
        frame.setSize(xSize, ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new Menu());
	}

    public static String getNext() {
		return next;
    }
}