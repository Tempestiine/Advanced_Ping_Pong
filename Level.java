package software;

public class Level {
	private int ballSpeed, paddleHeight, paddleSpeed;
	
	public Level(int bs, int ph, int ps) {
		ballSpeed = bs;
		paddleHeight = ph;
		paddleSpeed = ps;
	}
	// Accessor Methods
	public int getBallSpeed() { return ballSpeed; }
	public int getPaddleHeight() { return paddleHeight; }
	public int getPaddleSpeed() { return paddleSpeed; }
}