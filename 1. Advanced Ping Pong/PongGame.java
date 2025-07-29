package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import software.objects.*;
// ACTIONLISTENER, KEYLISTENER
public class PongGame extends JPanel implements MouseMotionListener, KeyListener {
	static final int WINDOW_WIDTH = 640;
	static final int WINDOW_HEIGHT = 480;
	private Ball gameBall;
	private Paddle userPaddle, pcPaddle;
	private int userScore, pcScore;
	private int bounceCount;
	private String gameState;
	private boolean twoPlayer;
	private boolean up, down;
	private MyQueue<Level> levels;
	// Mouse Y Coordinate
	private int userMouseY;

	public PongGame() {
		gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
		userPaddle = new PlayerPaddle(10, 200, 75, 3, Color.BLUE);
		userScore = pcScore = 0;
		bounceCount = 0;
		userMouseY = 0;
		twoPlayer = false;
		gameState = "TITLE";
			// Listen for Events on PongGame
		addMouseMotionListener(this);
		addKeyListener(this);
			// Game actually pays attention to Keyboard input???
		setFocusable(true);
		requestFocusInWindow();
			// Set up Level
		levels = new MyQueue<Level>();
		// APPRIOPRIATE CHALLENGE
		levels.enQueue(new Level(3, 75, 3));
		levels.enQueue(new Level(4, 65, 4));
		levels.enQueue(new Level(5, 55, 5));
		levels.enQueue(new Level(6, 45, 5));
	}
	// Draw Component
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
		// TITLE SCREEN
		if (gameState.equals("TITLE")) {
			g.setColor(Color.WHITE);
			g.drawString("PONG", 280, 150);
			g.drawString("Press 1 for Single Player", 220, 200);
			g.drawString("Press 2 for Two Player", 230, 240);
		} else {
				// Ball
			gameBall.paint(g);
				// Paddles
			userPaddle.paint(g);
			pcPaddle.paint(g);
				// Score
			g.setColor(Color.WHITE);
			g.drawString("Score - User [ "+userScore+" ] PC [ "+pcScore +
				" ]" , 250, 20);
			g.drawString("Level [" + levels.getNum() + "]", 300, 50);
			g.drawString("Objective: Prevent the ball from touching your goal!", 200, 460);
				// PLAYER FEEDBACK
			String advice = "";
			if (userScore > pcScore + 1)
				advice = "Keep it up, Player 1!";
			else if (userScore > pcScore)
				advice = "Try to predict where the ball's going, Player 2.";
			else if (pcScore > userScore + 1)
				advice = "Good job, Player 2.";
			else if (pcScore > userScore)
				advice = "Player 1, focus on the ball!";
			else
				advice = "Both of you are tied! Hurry and take the lead.";
			g.drawString(advice, 180, 440);
		}
	}
	public void gameLogic() {
		if (gameState.equals("TITLE"))
			return; // NO GAME LOGIC UNTIL WE'RE PLAYING
			// Ball Movement
		gameBall.moveBall();
		gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
			// Paddle Movement
		userPaddle.moveTowards(userMouseY);
		if (!twoPlayer)
			pcPaddle.moveTowards(gameBall.getY());
		else {
			if (up)
				pcPaddle.moveTowards(pcPaddle.getY() - 100);
			if (down)
				pcPaddle.moveTowards(pcPaddle.getY() + 100);
		}
			// COLLISION DETECTION + Scoring
		if (userPaddle.checkCollision(gameBall) || pcPaddle.checkCollision(gameBall)) {
			gameBall.reverseX();
			bounceCount++;
		}
		if (bounceCount == 5) {
			bounceCount = 0;
			gameBall.increaseSpeed();
		}
		if (gameBall.getX() < 0) {
			pcScore++;
			reset();
		} else if (gameBall.getX() > WINDOW_WIDTH) {
			userScore++;
			reset();
		}
	}
	// Reset Game to a new Round
	public void reset() {
		// EXCEPTION AND ERROR HANDLING
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Level next;
		try {
			next = levels.deQueue();
		} catch (RuntimeException e) {
			next = new Level(
				(int) (Math.random() * 4) + 3,
				(int) (Math.random() * 45) + 30,
				(int) (Math.random() * 3) + 3);
		}
		gameBall.setSpeed(next.getBallSpeed());
		int newHeight = next.getPaddleHeight();
		int newSpeed = next.getPaddleSpeed();
		gameBall.setX(300);
		gameBall.setY(200);
		gameBall.setCx(3);
		gameBall.setCy(3);
		bounceCount = 0;
		userPaddle = new PlayerPaddle(10, userPaddle.getY(),
					newHeight, newSpeed, Color.BLUE);
		if (twoPlayer) {
			pcPaddle.setHeight(newHeight);
			pcPaddle.setSpeed(newSpeed);
		} else
			pcPaddle = new ComputerPaddle(610, pcPaddle.getY(), newHeight,
					 newSpeed, Color.RED);

	}

	// Inputs
	public void mouseMoved(MouseEvent e) {
		userMouseY = e.getY();
	}
	public void keyPressed(KeyEvent e) {
	if (gameState.equals("TITLE")) {
		if (e.getKeyCode() == KeyEvent.VK_1) {
			twoPlayer = false;
			gameState = "PLAYING";
			pcPaddle = new ComputerPaddle(610, 200, 75, 3, Color.RED);
			} else if (e.getKeyCode() == KeyEvent.VK_2) {
				twoPlayer = true;
				gameState = "PLAYING";
				pcPaddle = new PlayerPaddle(610, 200, 75, 3, Color.RED);
			}
		} else if (twoPlayer && gameState.equals("PLAYING")) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				up = true;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				down = true;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
	}	
	@Override
		public void mouseDragged(MouseEvent e) {}	
	@Override
		public void keyTyped(KeyEvent e) {}
			
		
}