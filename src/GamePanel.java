import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{

  private Apple apple;
  private Snake snake;
  private Timer timer;

  public GamePanel() {
    addKeyListener(new MyKeyAdaper());

    setPreferredSize(new Dimension(SnakeGame.SCREEN_WIDTH, SnakeGame.SCREEN_HEIGHT));
    setBackground(Color.black);
    setFocusable(true);

    apple = new Apple();
    snake = new Snake();
    timer = new Timer(SnakeGame.DELAY, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  public void draw(Graphics g) {
    // draw board
    for(int i=0;i<SnakeGame.SCREEN_HEIGHT / SnakeGame.UNIT_SIZE; i++) {
      g.drawLine(0, i*SnakeGame.UNIT_SIZE, SnakeGame.SCREEN_WIDTH, i*SnakeGame.UNIT_SIZE);
    }
    for(int i=0;i<SnakeGame.SCREEN_WIDTH / SnakeGame.UNIT_SIZE; i++) {
      g.drawLine(i*SnakeGame.UNIT_SIZE, 0, i*SnakeGame.UNIT_SIZE, SnakeGame.SCREEN_HEIGHT);
    }

    apple.draw(g);
    snake.draw(g);

    g.setColor(Color.red);
    g.setFont(new Font("Ink Tree", Font.PLAIN, 40));
    FontMetrics metrics = getFontMetrics(g.getFont());
    g.drawString(Score.textScore, (SnakeGame.SCREEN_WIDTH - metrics.stringWidth(Score.textScore)) / 2, 40);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    snake.move();
    if(snake.checkCollision()) {
      gameOver();
    }
    if(snake.checkEatApple(apple)) {
      snake.eatApple();
      Score.increaseScore();
      apple = new Apple();
    }
    repaint();   
  }

  public void gameOver() {
    System.out.println("Game over");
    timer.stop();
    new GameOver().main(new String[] {});
  }

  class MyKeyAdaper extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				snake.setDirection('L');
				break;
			case KeyEvent.VK_RIGHT:
				snake.setDirection('R');
				break;
			case KeyEvent.VK_UP:
				snake.setDirection('U');
				break;
			case KeyEvent.VK_DOWN:
				snake.setDirection('D');
				break;
			default:
				break;
      }
    }
  } 

}
