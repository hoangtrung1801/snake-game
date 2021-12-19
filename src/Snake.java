import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Snake {
  private int len = 3;
	private int[] x = new int[SnakeGame.GAME_UNITS];
	private int[] y = new int[SnakeGame.GAME_UNITS];
	private char direction = 'R';
	
	Random random = new Random();

	public void draw(Graphics g) {
		for(int i=0;i<len;i++) {
			if(i==0) g.setColor(Color.green);
//			else g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			else g.setColor(new Color(45, 180, 0));
			g.fillRect(x[i], y[i], SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE);
		}
	}

	public void move() {
		for(int i=len;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch (direction) {
		case 'R':
			x[0] += SnakeGame.UNIT_SIZE;
			break;
		case 'U':
			y[0] -= SnakeGame.UNIT_SIZE;
			break;
		case 'L':
			x[0] -= SnakeGame.UNIT_SIZE;
			break;
		case 'D':
			y[0] += SnakeGame.UNIT_SIZE;
			break;
		default:
			break;
		}
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		if(this.direction == 'L' && direction == 'R'
			|| this.direction == 'R' && direction == 'L'
			|| this.direction == 'U' && direction == 'D'
			|| this.direction == 'D' && direction == 'U'
		)  return;
		this.direction = direction;
	}
	
	public int getHeadX() {
		return x[0];
	}
	public int getHeadY() {
		return y[0];
	}
	
	public boolean checkCollision( ) {
		if(x[0] < 0 || x[0]>= SnakeGame.SCREEN_WIDTH || y[0] < 0 || y[0] >= SnakeGame.SCREEN_HEIGHT) {
			return true;
		}
		for(int i=len;i>0;i--) 
			if(x[0] == x[i] && y[0] == y[i]) return true;
		
		return false;
	}
	
	public boolean checkEatApple(Apple apple) {
		if(x[0] == apple.getX() && y[0] == apple.getY()) {
			return true;
		}
		return false;
	}
  public void eatApple() {
    len++;
  }
}
