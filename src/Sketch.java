import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Sketch extends JPanel {
  Sketch() {
    readCoordinatesFromFile();
  }

  static List<Integer> xCord = new ArrayList<>();
  static List<Integer> yCord = new ArrayList<>();

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    for (int i = 0; i < xCord.size(); i++) {
      int x = xCord.get(i);
      int y = yCord.get(i);

      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(5));
      g2.draw(new Line2D.Float(x - 300, y - 300, x - 300, y - 300));
    }
  }

  public static void main(String[] args) {
    try {
      Sketch sketch = new Sketch();

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int width = (int) screenSize.getWidth();
      int height = (int) screenSize.getHeight();

      JFrame frame = new JFrame("Mouse Tracker");
      frame.setSize(width, height);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.add(sketch);
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }

  private void readCoordinatesFromFile() {
    try {
      File myObj = new File("./data/drag_tracks.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        int x = Integer.parseInt(myReader.next());
        int y = Integer.parseInt(myReader.next());
        xCord.add(x);
        yCord.add(y);

        if (!myReader.nextLine().isEmpty())
          break;
      }

      myReader.close();
    } catch (IOException e) {
      System.out.print(e);
      e.printStackTrace();
    }
  }
}