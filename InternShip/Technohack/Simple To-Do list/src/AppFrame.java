import javax.swing.JFrame;

public class AppFrame extends JFrame{
    AppFrame(){
        this.add(new AppPanel());
        this.setTitle("To-do List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}
