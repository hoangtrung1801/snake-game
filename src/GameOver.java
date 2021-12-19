import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameOver extends JFrame {
  JPanel panel;
  private String textGameOver = "Game over";

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new GameOver();
      }
    });
  }

  public GameOver() {
    panel = new JPanel();

    draw();
    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Snake Game");
    pack();
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public void draw() {
    panel.setPreferredSize(new Dimension(SnakeGame.SCREEN_WIDTH, SnakeGame.SCREEN_HEIGHT));
    panel.setBackground(Color.black);
    panel.setFocusable(true);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
		
		panel.add(new JPanel() {
			{
				this.setBackground(Color.black);
			}
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.red);
				g.setFont(new Font("Ink Free", Font.BOLD, 75));
				FontMetrics metrics1 = getFontMetrics(g.getFont());
				g.drawString(textGameOver, (SnakeGame.SCREEN_WIDTH - metrics1.stringWidth(textGameOver)) / 2, metrics1.getHeight());

				g.setFont(new Font("Ink Free", Font.BOLD, 40));
				FontMetrics metrics2 = getFontMetrics(g.getFont());
				g.drawString(Score.textScore, (SnakeGame.SCREEN_WIDTH - metrics2.stringWidth(Score.textScore)) / 2, metrics2.getHeight() + 100);
			}
		});
		// panel.add(bottom);
		panel.add(Box.createRigidArea(new Dimension(0, 200)));
  }
}
