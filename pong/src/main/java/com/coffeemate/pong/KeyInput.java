import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    Player player;
    Player2 player2;

    public KeyInput(Player player, Player2 player2) {
        this.player = player;
        this.player2 = player2;
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        player2.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
        player2.keyReleased(e);
    }
}