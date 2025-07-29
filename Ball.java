package software.objects;
import java.awt.*;
// ENCAPSULATION
public class Ball {
	private int x, y, cx, cy, size, speed;
	static final int MAX_SPEED = 7;
	private Color color;
	public Ball(int x, int y, int cx, int cy, int speed,
			Color color, int size) {
		if (speed < 0)
			throw new IllegalArgumentException("Speed can not be negative.");
		this.x = x;
		this.y = y;
		this.cx = cx;
		this.cy = cy;
		this.size = size;
		this.speed = speed;
		this.color = color;
	}
	//Accessor Methods
	public int getY() { return y; }
	public int getX() { return x; }
	public int getCX() { return cx; }
	public int getCY() { return cy; }
	public int getSize() { return size; }
	public int getSpeed() { return speed; }
	//Modifier Methods
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setCx(int cx) {this.cx = cx; }
	public void setCy(int cy) { this.cy = cy; }
	public void setSpeed( int speed) { this.speed = speed; }
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x,y,size,size);
	}
	public void moveBall() {
		x += cx;
		y += cy;
	}
	public void increaseSpeed() {
		if (speed < MAX_SPEED) {
			speed++;
			if (cx > 0)
				cx = speed;
			else if (cx < 0)
				cx = speed * -1;
			if (cy > 0)
				cy = speed;
			else if (cy < 0)
				cy = speed * -1;
		}
	}
	public void bounceOffEdges(int top, int bottom) {
		if (y > bottom - size)
			reverseY();
		else if (y < top)
			reverseY();
	}
	public void bounce() {
		reverseX();
		reverseY();
	}
	public void reverseX() {
		cx *= -1;
	}
	public void reverseY() {
		cy*= -1;
	}
}