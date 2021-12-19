import java.awt.*;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartGame extends JFrame {
  JPanel panel;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new StartGame();
      }
      
    });
  }

  public StartGame() {
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
		
		JPanel bottom = new JPanel();
		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		JButton playGameButton = new JButton("Play game");
		playGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
        System.out.println("Play game");
				new GameFrame();
			}
		});

		bottom.add(playGameButton);
		
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
				g.drawString("Snake Game", (600 - metrics1.stringWidth("Snake Game")) / 2, metrics1.getHeight());
			}
		});
		panel.add(bottom);
		panel.add(Box.createRigidArea(new Dimension(0, 200)));
  }
}
