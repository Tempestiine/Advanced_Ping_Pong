// ACTION LISTENER
package software;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	static JFrame f = new JFrame("Pong");
	public static void main(String... args) {
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// MUST: JFrame size > Game size
		f.setSize(650,525);
		// Making a new game
		PongGame game = new PongGame();
		f.add(game);
		f.setVisible(true);
		game.requestFocusInWindow();
		// Timer for Frames
		// EXCEPTION AND ERROR HANDLING
		Timer timer = new Timer(33, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Every 33 frames, perform an action.
				try {
					game.gameLogic();
					game.repaint();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		timer.start();
	}

}