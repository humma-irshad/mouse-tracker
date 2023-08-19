import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sketch extends Frame {
  public Sketch() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    setVisible(true);
    setSize(width, height);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public void paint(Graphics g) {
    try {
      File myObj = new File("./data/drag_tracks");
      Scanner myReader = new Scanner(myObj);
      List<Integer> stringFile = new ArrayList<Integer>();
      List<Integer> xCord = new ArrayList<Integer>();
      List<Integer> yCord = new ArrayList<Integer>();

      String str;
      while (myReader.hasNextLine()) {
        str = myReader.next();
        Integer strInt = Integer.parseInt(str);
        stringFile.add(strInt);

        Integer[] array = stringFile.toArray(new Integer[0]);
        for (Integer j = 0; j < array.length; j++) {
          if ((float) j % 2 != 0) {
            yCord.add(array[j]);
          } else {
            xCord.add(array[j]);
          }
        }
      }

      Integer[] xCordArray = xCord.toArray(new Integer[0]);
      for (int i = 0; i < xCordArray.length; i++) {
        System.out.print(xCordArray[i]);
      }

      myReader.close();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public static void main(String[] args) {
    new Sketch();
  }
}