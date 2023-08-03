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

    int limit = 5;
    int guessNum;
    int inputNum;

    JLabel gameName = new JLabel("Number Guessing Game");
    JLabel outPutTxt = new JLabel("Sample Text");
    JLabel limitTxt = new JLabel("Limit: " + limit);
    JTextField numberArea = new JTextField("100",5);
    JButton newGameBtn = new JButton("New Number");
    JButton guessBtn = new JButton("Guess");

    Random random = new Random();
    SpringLayout layOut = new SpringLayout();

    GamePanel(){
        guessNum = random.nextInt(100);
        this.setLayout(layOut);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        
        this.add(gameName);
        this.add(outPutTxt);
        this.add(numberArea);
        this.add(newGameBtn);
        this.add(guessBtn);
        this.add(limitTxt);

        gameName.setFont(new Font("Arial", Font.BOLD, 30));

        // gameName.setBounds(30, 10, 400, 30);
        // numberArea.setBounds(180, 50, 50, 30);
        // limitTxt.setBounds(183, 80, 50, 30);
        // guessBtn.setBounds(90, 110, 110, 30);
        // newGameBtn.setBounds(210, 110, 110, 30);
        // outPutTxt.setBounds(150,150,250,30);

        guessBtn.addActionListener(this);
        newGameBtn.addActionListener(this);
        numberArea.addKeyListener(this);


        layOut.putConstraint(SpringLayout.NORTH, gameName, 10, SpringLayout.NORTH, this);
        layOut.putConstraint(SpringLayout.WEST, gameName, 25, SpringLayout.WEST, this);
        layOut.putConstraint(SpringLayout.NORTH, numberArea, 10, SpringLayout.SOUTH, gameName);
        layOut.putConstraint(SpringLayout.WEST, numberArea, 170, SpringLayout.WEST, this);
        layOut.putConstraint(SpringLayout.NORTH, guessBtn,10 , SpringLayout.SOUTH, numberArea);
        layOut.putConstraint(SpringLayout.WEST, guessBtn,110 , SpringLayout.WEST, this);
        layOut.putConstraint(SpringLayout.NORTH,newGameBtn,10 , SpringLayout.SOUTH, numberArea);
        layOut.putConstraint(SpringLayout.WEST,newGameBtn,20 , SpringLayout.EAST, guessBtn);

        // layOut.putConstraint(SpringLayout.NORTH, guessBtn, 20, SpringLayout.NORTH, this);
    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void checkNum() {
        if( inputNum == guessNum ){
            System.out.println("Win!!!");
            outPutTxt.setText("WIN!!!!");
        }
        else if(inputNum > guessNum){
            System.out.println("input is higher than guesss number");
            outPutTxt.setText("input is higher than guesss number");
        }
        else{
            System.out.println("input is lower than guess Number");
            outPutTxt.setText("input is lower than guess Number");
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if(arg0.getKeyChar() == '\n'){
            // System.out.println("Enter");
            // numberArea.setText("");
            // checkNum();
        }
        // System.out.println(arg0.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

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
            System.out.println(guessNum);
        }
    }


}
