import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;
public class AppPanel extends JPanel {

    final int width = 300;
    final int height = 500;

    JButton add_task = new JButton("Add");
    JButton delete_task = new JButton("Delete");
    JTextField text_field = new JTextField();

    ArrayList<Task> task_array = new ArrayList<Task>();

    AppPanel(){
        
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.white);
        // this.add(add_task);
        // this.add(delete_task);
        this.add(text_field);
        text_field.setBounds(0,0,width,height);
    }
}
