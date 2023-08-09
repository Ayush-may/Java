import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.*;


public class AppPanel extends JPanel implements ActionListener {

    final int width = 300;
    final int height = 500;
    int delay = 10;

    JPanel panel = new JPanel();
    JButton add_task = new JButton("Add");
    JButton delete_task = new JButton("Delete");
    JTextField text_field = new JTextField("",20);

    SpringLayout spring = new SpringLayout();
    ArrayList<Task> task_array = new ArrayList<Task>();
    Timer timer;
    Font font1 = new Font("SansSerif", Font.BOLD, 15);

    AppPanel() {
        this.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(width, height - 80));
        this.setPreferredSize(new Dimension(width, height));
        this.add(panel);
        this.add(text_field);
        this.add(add_task);
        this.add(delete_task); 
        add_task.addActionListener(this);
        delete_task.addActionListener(this);

        text_field.setFont(font1);        
        timer = new Timer(delay, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                for(Task a:task_array){
                    panel.add(a);
                    System.out.println("sd");
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
        if(e.getSource() == add_task){
            task_array.add(new Task(text_field.getText()));
            panel.revalidate();
            System.out.println(text_field.getText());
        }
        if(e.getSource() == delete_task){
            ArrayList<Task> task_temp_array = new ArrayList<Task>();

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

}
