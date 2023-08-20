import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GravityPanel extends JPanel implements ActionListener{
	
	int width = 500;
	int height = 500;
	
	int t = 20;
	int delay = 24;
	int ballSize = 50;
	Timer timer ;
	Ball ball;
	int dx = 2;
	float acc = 2.5f;
	float gravity = 1f;
	Rectangle2D.Double smallRect, bigRect;
	ArrayList<Ball> ballArr = new ArrayList<>();
	Random random = new Random();
	
	GravityPanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.white);
		
		init();

		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void init() {
		while(t-- != 0) {
			ballArr.add(new Ball(random.nextInt(width),random.nextInt(500),random.nextInt(3)));
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);  		
		for(int i=0;i<ballArr.size();i++) {
			g.setColor(Color.BLACK);
			g.drawOval((int)ballArr.get(i).getX(), (int)ballArr.get(i).getY(), ballArr.get(i).getSize(), ballArr.get(i).getSize());
			g.setColor(Color.BLUE);
			g.fillOval((int)ballArr.get(i).getX()+1, (int)ballArr.get(i).getY()+1, ballArr.get(i).getSize()-1, ballArr.get(i).getSize()-1);	
		}
	}

	public void update() {
		
		for(int i=0;i<ballArr.size();i++) {
			
			if( (ballArr.get(i).getY() + ballArr.get(i).getSize()) > height ) {
				if( ballArr.get(i).getAcc() > 0) {
					ballArr.get(i).setAcc(-(int)(ballArr.get(i).getAcc() * 1 ) );	
				} 
			}
			else {
				ballArr.get(i).setAcc( ballArr.get(i).getAcc() + ballArr.get(i).getGravity());
			}
			if(ballArr.get(i).getX() + ballArr.get(i).getSize() > width) {
				if( ballArr.get(i).getDX() > 0 ) {
					ballArr.get(i).setDX( -(int)(ballArr.get(i).getDX() * 1) );	
				}
			}
			if(ballArr.get(i).getX() < 0) {
				ballArr.get(i).setDX( ballArr.get(i).getDX() * -1 );

			}
			ballArr.get(i).setX((int)(ballArr.get(i).getX()+ ballArr.get(i).getDX()));
			ballArr.get(i).setY(ballArr.get(i).getY() + ballArr.get(i).getAcc());			
		}
		
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.width = this.getWidth();
		this.height = this.getHeight();
		update();
	}
	
	
}
