import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Task extends JPanel implements MouseListener{
    private String task = "";
    private JLabel label;
    final int width = 300;
    Border blackline = BorderFactory.createLineBorder(Color.black);
    boolean check = false;

    Task(String task){
        this.task = task;
        this.setBorder(blackline);
        label = new JLabel(task,SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(label);
        // this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(width, 30));
        this.setVisible(true);
        addMouseListener(this);
    }

    public void setString(String task){
        this.task = task;
    }

    public String getString(){ 
        return task;
    }

    public boolean get_check(){
        return check;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        check = true;
        this.setBackground(Color.green);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }



    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
