import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.*;


public class AppPanel extends JPanel implements ActionListener , KeyListener{

    final int width = 300;
    final int height = 500;
    int delay = 10;

    JPanel panel = new JPanel();
    JButton add_task = new JButton("Add");
    JButton delete_task = new JButton("Delete");
    JLabel name = new JLabel("To-Do List");
    JTextField text_field = new JTextField("",20);

    SpringLayout spring = new SpringLayout();
    ArrayList<Task> task_array = new ArrayList<Task>();
    Timer timer;
    Font font1 = new Font("SansSerif", Font.BOLD, 15);

    AppPanel() {
        this.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(width, height - 110));
        this.setPreferredSize(new Dimension(width, height));
        name.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(name);
        this.add(panel);
        this.add(text_field);
        this.add(add_task);
        this.add(delete_task); 
        add_task.addActionListener(this);
        delete_task.addActionListener(this);

        this.setFocusable(true);
        text_field.addKeyListener(this);

        text_field.setFont(font1);        
        timer = new Timer(delay, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                for(Task a:task_array){
                    panel.add(a);
                }
                panel.revalidate();
                panel.repaint();
            }

        });

        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_task ){
            task_array.add(new Task(text_field.getText()));
            panel.revalidate();
            text_field.setText("");
        }
        if(e.getSource() == delete_task){
            ArrayList<Task> task_temp_array = new ArrayList<Task>();
            text_field.setText("");
            for(Task a:task_array){
                if(!a.get_check()){
                    task_temp_array.add(a);
                }
            }
            task_array = task_temp_array;
            panel.revalidate();
            panel.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() ==  10){
            task_array.add(new Task(text_field.getText()));
            panel.revalidate();
            text_field.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
