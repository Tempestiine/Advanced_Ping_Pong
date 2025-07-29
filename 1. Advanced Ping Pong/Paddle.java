package software.objects;

import java.awt.*;
import software.objects.Ball;
public class Paddle {
	private int height, x, y, speed;
	private Color color;
	static final int PADDLE_WIDTH = 15;

	public Paddle(int x, int y, int height, int speed, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.speed = speed;
		this.color = color;
	}
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, PADDLE_WIDTH, height);
	}
	// Accessor Method
	public int getY() { return y; }
	// Set Method
	public void setHeight(int height) { this.height = height; }
	public void setSpeed(int speed) { this.speed = speed; }
	// Collision
	public boolean checkCollision(Ball b) {
		int rightX = x + PADDLE_WIDTH;
		int bottomY = y + height;
		if (b.getX() > (x - b.getSize()) && b.getX() < rightX)
			if (b.getY() > y && b.getY() < bottomY)
				return true;
		return false;
	}
	// Paddle Center's calculated from the starting Y point
	public void moveTowards(int moveToY) {
		int centerY = y + height/2;
		// Absolute value prevents the paddle from jiggling
		if (Math.abs(centerY - moveToY) > speed) {
			if (centerY > moveToY)
				y -= speed;
			if (centerY < moveToY)
				y += speed;
		}
	}
}