import javax.swing.JPanel;

public abstract class Score extends JPanel {
  public static int score;
  public static String textScore = "Score : " + score;
  public static void increaseScore() {
    score++;
    textScore = "Score : " + score;
  }
  public static void resetScore() {
    score = 0;
  }

}
