import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new GameFrame();
      }
    });
  }
  
  public GameFrame() {
    GamePanel panel = new GamePanel();

    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Snake Game");
    pack();
    setVisible(true);
    setLocationRelativeTo(null);
  }
}
