import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App extends JComponent implements NativeMouseInputListener {
  static FileWriter fileWriter;
  static List<Integer> xCord = new ArrayList<>();
  static List<Integer> yCord = new ArrayList<>();
  // static CustomPaintPanel panel1 = new CustomPaintPanel();

  // static class CustomPaintPanel extends JPanel {
  //   @Override
  //   public void paint(Graphics g) {
  //     super.paint(g);

  //     for (int i = 0; i < xCord.size(); i++) {
  //       int x = xCord.get(i);
  //       int y = yCord.get(i);

  //       g.setColor(Color.BLUE);
  //       g.drawLine(x, y, x, y);
  //     }
  //   }
  // }

  public void nativeMouseClicked(NativeMouseEvent e) {
    try {
    FileWriter clickFile = new FileWriter("./data/click_tracks.txt", true);

    clickFile.write("Mouse clicked " + e.getClickCount() + " times\n");
    clickFile.close();

    } catch (IOException ex) {
    System.out.println(ex);
    System.out.println(ex.getMessage());
    }
  }

  public void nativeMousePressed(NativeMouseEvent e) {
    try {
    FileWriter pressedFile = new FileWriter("./data/pressed_tracks.txt", true);

    pressedFile.write("Mouse pressed " + e.getButton() + " times\n");
    pressedFile.close();
    } catch (IOException ex) {
    System.out.println(ex);
    System.out.println(ex.getMessage());
    }
  }

  public void nativeMouseReleased(NativeMouseEvent e) {
    try {
    FileWriter releaseFile = new FileWriter("./data/release_tracks.txt", true);

    releaseFile.write("Mouse released " + e.getButton() + " times\n");
    releaseFile.close();
    } catch (IOException ex) {
    System.out.println(ex);
    System.out.println(ex.getMessage());
    }
  }

  public void nativeMouseMoved(NativeMouseEvent e) {
    try {
      FileWriter moveFile = new FileWriter("./data/move_tracks.txt", true);

      moveFile.write(e.getX() + " " + e.getY() + "\n");
      moveFile.close();

    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println(ex.getMessage());
    }
  }

  public void nativeMouseDragged(NativeMouseEvent e) {
    try {
      FileWriter dragFile = new FileWriter("./data/drag_tracks.txt", true);

      dragFile.write("Mouse dragged " + e.getX() + ", " + e.getY() + "\n");
      dragFile.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println(ex.getMessage());
    }
  }

  public static void main(String[] args) {
    new App();
  }
}

// import java.awt.*;
// import java.io.FileWriter;
// import java.io.IOException;
// import javax.swing.*;
// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseMotionListener;

// class App extends Frame implements MouseMotionListener {
// static JLabel label;
// static FileWriter fileWriter;
// static List<Integer> xCord = new ArrayList<>();
// static List<Integer> yCord = new ArrayList<>();
// static CustomPaintPanel panel1 = new CustomPaintPanel();

// App() {
// readCoordinatesFromFile();
// }

// public static void main(String[] args) {
// SwingUtilities.invokeLater(() -> {
// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

// int width = (int) screenSize.getWidth();
// int height = (int) screenSize.getHeight();

// JFrame f = new JFrame("MouseMotionListener");
// f.setSize(width, height);
// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// JPanel panel = new JPanel();

// label = new JLabel("No event ");

// App m = new App();
// f.addMouseMotionListener(m);
// panel1.add(label);
// panel.add(panel1, BorderLayout.NORTH);
// f.add(panel1);
// f.setVisible(true);
// // Sketch sketch = new Sketch();
// });
// }

// static class CustomPaintPanel extends JPanel {
// @Override
// public void paint(Graphics g) {
// super.paint(g);

// for (int i = 0; i < xCord.size(); i++) {
// int x = xCord.get(i);
// int y = yCord.get(i);

// g.setColor(Color.BLUE);
// g.drawLine(x, y, x, y);
// }
// }
// }

// public void mouseDragged(MouseEvent e) {
// try {
// xCord.add(e.getX());
// yCord.add(e.getY());
// panel1.repaint();
// fileWriter = new FileWriter("./data/drag_tracks", true);
// fileWriter.write(e.getX() + " " + e.getY() + "\n");
// label.setText("mouse is dragged through point "
// + e.getX() + " " + e.getY());

// fileWriter.close();
// } catch (IOException ex) {
// System.err.println(ex.getMessage());
// }
// }

// public void mouseMoved(MouseEvent e) {
// }

// private void readCoordinatesFromFile() {
// try {
// File myObj = new File("./data/drag_tracks");
// Scanner myReader = new Scanner(myObj);

// while (myReader.hasNextLine()) {
// int x = Integer.parseInt(myReader.next());
// int y = Integer.parseInt(myReader.next());

// xCord.add(x);
// yCord.add(y);
// }

// myReader.close();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }