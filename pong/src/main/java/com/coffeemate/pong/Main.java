import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    static int xSize = 640;
    static int ySize = 480;
    int x = xSize/16;
    int y = ySize/2 - 60;
    boolean run = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong!");
        frame.pack();
        frame.setResizable(false);
        frame.setSize(xSize, ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Game());
        frame.setVisible(true);
    }

    public int getXFrame() {
        return xSize;
    }

    public int getYFrame() {
        return ySize;
    }
    
    /*
    public void menu(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("OCR A Std", Font.BOLD, 72));
        g.drawString("PONG!", xSize/2 - 125, ySize/4);

        JButton play = new JButton("PLAY");
        play.setBounds(xSize/2 - 60, ySize/2, 100, 50);
        frame.add(play);
        play.setVisible(true);
        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                run = true;
            }
        }); 
    }
    */

}
