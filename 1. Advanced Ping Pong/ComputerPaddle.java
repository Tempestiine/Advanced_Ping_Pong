package software.objects;

import java.awt.*;
import java.util.Random;
// INHERITANCE
public class ComputerPaddle extends Paddle {
	private int glitch;
	
	public ComputerPaddle(int x, int y, int height, int speed, Color color) {
		super(x, y, height, speed, color);
		glitch = 0;
	}
	// This makes the Computer Paddle intentionally miss
	@Override
	public void moveTowards(int moveToY) {
		if (glitch == 0) {
			int direction = (int) (Math.random() * 3) - 1;
			super.moveTowards(getY() + direction * 100);
			glitch = 300;
		} else {
			super.moveTowards(moveToY);
			glitch--;
		}
	}
}