import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JPanel;

public class Ball {
	
	float acc = 2f;
	float gravity = 2f;
	int size =50;
	float x,y;
	int dx = 4;
	Random random = new Random();
	
	
	Ball(int x,int y,int gravity){	
		this.x = x;
		this.y = y;
		this.gravity = gravity;
		this.size = random.nextInt(50);
//		this.dx = random.nextInt(5);
		
		if(random.nextInt(2) == 0) {
			this.dx = -this.dx;
		}

		if(this.size < 5) {
			this.size = 5;
		}
		
		if(this.gravity == 0) {
			this.gravity = 1;
		}
	}
	
	public void setDX(int dx) {
		this.dx = dx;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getSize() {
		return size;
	}
	
	public float getGravity() {
		return gravity;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getAcc() {
		return acc;
	}
	
	public void setAcc(float acc) {
		this.acc = acc;
	}
}
