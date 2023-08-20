import javax.swing.JFrame;

public class Main extends JFrame{
	
	Main(){
		this.add(new GravityPanel());
		this.setTitle("Gravity");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
