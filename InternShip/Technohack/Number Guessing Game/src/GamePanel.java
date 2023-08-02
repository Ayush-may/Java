import java.awt.Dimension;
import javax.swing.*;

public class GamePanel extends JPanel {

    final int SCREEN_WIDTH = 400;
    final int SCREEN_HEIGHT = 200;

    GamePanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));


    }
}
