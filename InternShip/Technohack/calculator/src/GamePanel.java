import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    
    final int SCREEN_HEIGHT = 600;
    final int SCREEN_WIDTH = 400;

    JTextField resTextField = new JTextField();

    JButton btn_0 = new JButton("0");
    JButton btn_1 = new JButton("1");
    JButton btn_2 = new JButton("2");
    JButton btn_3 = new JButton("3");
    JButton btn_4 = new JButton("4");
    JButton btn_5 = new JButton("5");
    JButton btn_6 = new JButton("6");
    JButton btn_7 = new JButton("7");
    JButton btn_8 = new JButton("8");
    JButton btn_9 = new JButton("9");
    
    JButton btnClr = new JButton("CLR");
    JButton btnDel = new JButton("DEL");

    JButton btnDot = new JButton(".");
    JButton btnEqual = new JButton("=");
    JButton btnAdd = new JButton("+");
    JButton btnSub = new JButton("-");
    JButton btnDiv = new JButton("/");
    JButton btnMul = new JButton("*");
    

    GamePanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.addToPanel();
        this.addLocation();
    }


    public void paint(Graphics g){
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public void addToPanel(){
        this.add(resTextField);
        this.add(btn_0);
        this.add(btn_1);
        this.add(btn_2);
        this.add(btn_3);
        this.add(btn_4);
        this.add(btn_5);
        this.add(btn_6);
        this.add(btn_7);
        this.add(btn_8);
        this.add(btn_9);
        this.add(btnClr);
        this.add(btnDel);
        this.add(btnAdd);
        this.add(btnSub);
        this.add(btnDiv);
        this.add(btnMul);
        this.add(btnDot);
        this.add(btnEqual);
    }

    public void addLocation(){
        resTextField.setBounds(0, 0, 400, 100);
        btnClr.setBounds(0,100,200,90); 
        btnDel.setBounds(200,100,100,90); 
        btnDiv.setBounds(300,100,100,90);
        btn_1.setBounds(0,190,100,90);  
        btn_2.setBounds(100,190,100,90);  
        btn_3.setBounds(200,190,100,90);  
        btnMul.setBounds(300,190,100,90);  
        btn_4.setBounds(0,280,100,90);  
        btn_5.setBounds(100,280,100,90);
        btn_6.setBounds(200,280,100,90);
        btnAdd.setBounds(300,280,100,90);
        btn_7.setBounds(0,370,100,90);
        btn_8.setBounds(100,370,100,90);
        btn_9.setBounds(200,370,100,90);
        btnSub.setBounds(300,370,100,90);
        btnDot.setBounds(0,460,100,90);
        btn_0.setBounds(100,460,100,90);
        btnEqual.setBounds(200,460,200,90);
    }
}
