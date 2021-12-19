import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
  private int x;
  private int y;
  private Color color = Color.red;
  Random random;

  public Apple() {
    random = new Random();
    x = random.nextInt(SnakeGame.SCREEN_WIDTH / SnakeGame.UNIT_SIZE) * SnakeGame.UNIT_SIZE;
    y = random.nextInt(SnakeGame.SCREEN_HEIGHT / SnakeGame.UNIT_SIZE) * SnakeGame.UNIT_SIZE;
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, SnakeGame.UNIT_SIZE, SnakeGame.UNIT_SIZE);
  }

  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
}
