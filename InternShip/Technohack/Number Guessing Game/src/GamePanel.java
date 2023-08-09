import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener{

    final int SCREEN_WIDTH = 400;
    final int SCREEN_HEIGHT = 200;

    int limitvalue = 10;
    int limit = limitvalue;
    int guessNum;
    int inputNum;

    JLabel gameName = new JLabel("Number Guessing Game");
    JLabel limitTxt = new JLabel("Limit: " + limit);
    JTextField numberArea = new JTextField("",5);
    JTextField outPutTxt = new JTextField("",23);
    JButton newGameBtn = new JButton("New Number");
    JButton guessBtn = new JButton("Guess");

    Random random = new Random();
    SpringLayout layOut = new SpringLayout();

    GamePanel(){
        guessNum = random.nextInt(100);
        this.setLayout(layOut);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        
        this.setBackground(Color.WHITE);

        this.add(gameName);
        this.add(outPutTxt);
        this.add(numberArea);
        this.add(newGameBtn);
        this.add(guessBtn);
        this.add(limitTxt);

        gameName.setFont(new Font("Arial", Font.BOLD, 30));
        outPutTxt.setFont(new Font("Arial", Font.BOLD, 20));

        guessBtn.addActionListener(this);
        newGameBtn.addActionListener(this);
        numberArea.addKeyListener(this);

        outPutTxt.setEditable(false);

        //Number Guessing Game
        layOut.putConstraint(SpringLayout.NORTH, gameName, 10, SpringLayout.NORTH, this);
        layOut.putConstraint(SpringLayout.WEST, gameName, 25, SpringLayout.WEST, this);
        //Input textField
        layOut.putConstraint(SpringLayout.NORTH, numberArea, 10, SpringLayout.SOUTH, gameName);
        layOut.putConstraint(SpringLayout.WEST, numberArea, 170, SpringLayout.WEST, this);
        //Limit txt
        layOut.putConstraint(SpringLayout.NORTH, limitTxt, 10, SpringLayout.SOUTH, gameName);
        layOut.putConstraint(SpringLayout.WEST, limitTxt, 20, SpringLayout.EAST, numberArea);
        //Guess Number Button
        layOut.putConstraint(SpringLayout.NORTH, guessBtn,10 , SpringLayout.SOUTH, numberArea);
        layOut.putConstraint(SpringLayout.WEST, guessBtn,165 , SpringLayout.WEST, this);
        //New Number Button
        layOut.putConstraint(SpringLayout.NORTH,newGameBtn,10 , SpringLayout.SOUTH, guessBtn);
        layOut.putConstraint(SpringLayout.WEST,newGameBtn,146 , SpringLayout.WEST, this);
        //Output Area
        layOut.putConstraint(SpringLayout.WEST,outPutTxt,5 , SpringLayout.WEST, this);
        layOut.putConstraint(SpringLayout.SOUTH,outPutTxt,-10 , SpringLayout.SOUTH, this);
    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void checkNum() {

        limit--;

        if(limit != 0){
            if( inputNum == guessNum ){
                System.out.println("Win!!!");
                outPutTxt.setText("WIN!!!! number :" + guessNum);
                limitTxt.setText("Limit: " + limit);
            }   
            else if(inputNum > guessNum){
                System.out.println("input is higher than guesss number");
                outPutTxt.setText("input is higher than guesss number");
                limitTxt.setText("Limit: " + limit);
             }
            else{
                System.out.println("input is lower than guess Number");
                outPutTxt.setText("input is lower than guess Number");
                limitTxt.setText("Limit: " + limit);
            }
        }
        else{
            outPutTxt.setText("U Loss and the number was "+ guessNum);
            limitTxt.setText("Limit: " + limit);
            limit = limitvalue;
        }

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        
        if(arg0.getKeyChar() == '\n'){
            System.out.println("Enter");
            try {
                inputNum = Integer.parseInt(numberArea.getText());
                numberArea.setText("");
                System.out.println(inputNum);
                checkNum();
            } catch (Exception e) {}
        }
        //Escape Number
        if(arg0.getKeyCode() == 27){ 
            guessNum = random.nextInt(100);
            System.out.println(guessNum);            
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}
    @Override
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == guessBtn){
            try {
                inputNum = Integer.parseInt(numberArea.getText());
                numberArea.setText("");
                System.out.println(inputNum);
                checkNum();
            } catch (Exception e) {}
        }
        else if(arg0.getSource() == newGameBtn){
            guessNum = random.nextInt(100);
            limit = limitvalue;
            limitTxt.setText("Limit: " + limit);
            outPutTxt.setText("");
            System.out.println(guessNum);
            if(limit == 0){
                limit = limitvalue;
                limitTxt.setText("Limit: " + limit);
            }
        }
    }
}