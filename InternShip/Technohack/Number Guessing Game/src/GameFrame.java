import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new GamePanel());
		this.setResizable(false);
		this.pack();
		this.setLocation(200,50);
		this.setTitle("Calculator");
		this.setVisible(true);
    }
}
