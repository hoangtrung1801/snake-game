import java.awt.EventQueue;

public class SnakeGame {
  public static int SCREEN_WIDTH = 600;
  public static int SCREEN_HEIGHT = 600;
  public static int UNIT_SIZE = 25;
  public static int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
  public static int DELAY = 75;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new StartGame();
      }
    });
  }
}
