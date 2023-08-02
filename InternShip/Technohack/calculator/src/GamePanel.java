import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    
    final int SCREEN_HEIGHT = 550;
    final int SCREEN_WIDTH = 400;

    
    String res="";
    String resTemp="";
    Font bigFont = new Font("Arial", Font.BOLD, 20);
    Font textFieldFont = new Font("Arial", Font.BOLD, 65);

    boolean addBool, subBool, mulBool, divBool;
    boolean dotBool = true;

    Color greyColor = new Color(236, 240, 241);
    Color selectColor = new Color(170, 183, 184 );

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
        this.init();

        resTextField.setHorizontalAlignment(JTextField.RIGHT);
    }

    public void paint(Graphics g){
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_0){
            System.out.println("0");
            res += "0";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_1){
            System.out.println("1");
            res += "1";
            resTextField.setText(res);    
        }
        else if(e.getSource() == btn_2){
            System.out.println("2");
            res += "2";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_3){
            System.out.println("3");
            res += "3";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_4){
            System.out.println("4");
            res += "4";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_5){
            System.out.println("5");
            res += "5";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_6){
            System.out.println("6");
            res += "6";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_7){
            System.out.println("7");
            res += "7";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_8){
            System.out.println("8");
            res += "8";
            resTextField.setText(res);
        }
        else if(e.getSource() == btn_9){
            System.out.println("9");
            res += "9";
            resTextField.setText(res);
        }
        else if(e.getSource() == btnAdd){
            System.out.println("add");
            resTemp = res;
            addBool = true;
            subBool = divBool = mulBool = false;
            btnSelectColor();
            if(res != ""){
                btnAdd.setBackground(selectColor);
            }
            res = "";
            resTextField.setText(res);
            dotBool = true;
            
        }
        else if(e.getSource() == btnSub){
            System.out.println("sub");
            resTemp = res;
            subBool = true;
            addBool = divBool = mulBool = false;
            btnSelectColor();
            if(res != ""){
                btnSub.setBackground(selectColor);
            }
            res = "";
            resTextField.setText(res);
            dotBool = true;
        }
        else if(e.getSource() == btnMul){
            System.out.println("Mul");
            resTemp = res;
            mulBool = true;
            subBool = divBool = addBool = false;
            btnSelectColor();
            if(res != ""){
                btnMul.setBackground(selectColor);
            }
            res = "";
            resTextField.setText(res);
            dotBool = true;
        }
        else if(e.getSource() == btnDiv){
            System.out.println("div");
            resTemp = res;
            divBool = true;
            subBool = addBool = mulBool = false;
            btnSelectColor();
            if(res != ""){
                btnDiv.setBackground(selectColor);
            }
            res = "";
            resTextField.setText(res);
            dotBool = true;
        }
        else if(e.getSource() == btnDot){
            System.out.println("dot");
            if(res != ""){
                try { 
                    if(dotBool){
                        Integer.parseInt(res);  //used to check res is int or float
                        res = res + ".";
                        resTextField.setText(res);                    
                    }
                    dotBool = false;
                }  
                catch (NumberFormatException ee) { 
                    dotBool = false;
                } 
            }
            
        }
        else if(e.getSource() == btnEqual){
            System.out.println("equal");
            if(addBool){
                res = (Float.parseFloat(resTemp) + Float.parseFloat(res)) + "" ;
                resTextField.setText(res);
            }
            else if(subBool){
                res = (Float.parseFloat(resTemp) - Float.parseFloat(res)) + "" ;
                resTextField.setText(res);
            }
            else if(divBool){
                res = (Float.parseFloat(resTemp) / Float.parseFloat(res)) + "" ;
                resTextField.setText(res);
            }
            else if(mulBool){
                res = (Float.parseFloat(resTemp) * Float.parseFloat(res)) + "" ;
                resTextField.setText(res);
            }
            btnSelectColor();
        }
        else if(e.getSource() == btnDel){
            System.out.println("del");
            if(res != ""){
                try {
                    int temp = Integer.parseInt(res);
                    temp /=10;
                    res = temp + "";
                    resTextField.setText(res);
                } catch (Exception ee) {
                    // removeLastDigitFloat();
                }
            }
        }

        else if(e.getSource() == btnClr){
            System.out.println("clr");
            res = resTemp = "";
            resTextField.setText(res);
            btnSelectColor();
            dotBool = true;
        }   
    }

    public void removeLastDigitFloat(){
        int temp = (int)Float.parseFloat(res);
        float temp2 = Float.parseFloat(res) - temp;
        System.out.println(temp2);
    }

    public void init(){
        this.addToPanel();
        this.addLocation();
        this.addListener();
        this.setColor();
        this.setFontSize();
        resTextField.setEditable(false);
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

    public void addListener(){
        btn_0.addActionListener(this);
        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        btn_3.addActionListener(this);
        btn_4.addActionListener(this);
        btn_5.addActionListener(this);
        btn_6.addActionListener(this);
        btn_7.addActionListener(this);
        btn_8.addActionListener(this);
        btn_9.addActionListener(this);
        btnDel.addActionListener(this);
        btnClr.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMul.addActionListener(this);
        btnDot.addActionListener(this);
        btnEqual.addActionListener(this);
    }

    public void setColor(){
        resTextField.setBackground(Color.WHITE);
        btnEqual.setBackground(greyColor);
        btnClr.setBackground(new Color(255, 91, 91 ));
        btn_0.setBackground(Color.white);
        btn_1.setBackground(Color.white);
        btn_2.setBackground(Color.white);
        btn_3.setBackground(Color.white);
        btn_4.setBackground(Color.white);
        btn_5.setBackground(Color.white);
        btn_6.setBackground(Color.white);
        btn_7.setBackground(Color.white);
        btn_8.setBackground(Color.white);
        btn_9.setBackground(Color.white);
        btnAdd.setBackground(greyColor);
        btnSub.setBackground(greyColor);
        btnDiv.setBackground(greyColor);
        btnMul.setBackground(greyColor);
        btnDel.setBackground(greyColor);
        btnDot.setBackground(greyColor);
    }

    public void setFontSize(){
        resTextField.setFont(textFieldFont);
        btn_0.setFont(bigFont);
        btn_1.setFont(bigFont);
        btn_2.setFont(bigFont);
        btn_3.setFont(bigFont);
        btn_4.setFont(bigFont);
        btn_5.setFont(bigFont);
        btn_6.setFont(bigFont);
        btn_7.setFont(bigFont);
        btn_8.setFont(bigFont);
        btn_9.setFont(bigFont);
        btnDel.setFont(bigFont);
        btnClr.setFont(bigFont);
        btnAdd.setFont(bigFont);
        btnSub.setFont(bigFont);
        btnDiv.setFont(bigFont);
        btnMul.setFont(bigFont);
        btnDot.setFont(bigFont);
        btnEqual.setFont(bigFont);
    }

    public void btnSelectColor(){
        btnAdd.setBackground(greyColor);
        btnSub.setBackground(greyColor);
        btnDiv.setBackground(greyColor);
        btnMul.setBackground(greyColor);
    }
}
