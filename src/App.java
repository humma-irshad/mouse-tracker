// import com.github.kwhat.jnativehook.GlobalScreen;
// import com.github.kwhat.jnativehook.NativeHookException;
// import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
// import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
// import javax.swing.JFrame;
// import javax.swing.JComponent;
// import java.awt.Graphics;
// import java.io.FileWriter;
// import java.io.File;
// import java.io.IOException;
// import java.util.Scanner;

// class MouseListener extends JComponent implements NativeMouseInputListener {
//   public void nativeMouseClicked(NativeMouseEvent e) {
//     try {
//       FileWriter clickFile = new FileWriter("./data/click_tracks.txt", true);

//       clickFile.write("Mouse clicked " + e.getClickCount() + " times\n");
//       clickFile.close();

//     } catch (IOException ex) {
//       System.out.println(ex);
//       System.out.println(ex.getMessage());
//     }
//   }

//   public void nativeMousePressed(NativeMouseEvent e) {
//     try {
//       FileWriter pressedFile = new FileWriter("./data/pressed_tracks.txt", true);

//       pressedFile.write("Mouse pressed " + e.getButton() + " times\n");
//       pressedFile.close();
//     } catch (IOException ex) {
//       System.out.println(ex);
//       System.out.println(ex.getMessage());
//     }
//   }

//   public void nativeMouseReleased(NativeMouseEvent e) {
//     try {
//       FileWriter releaseFile = new FileWriter("./data/release_tracks.txt", true);

//       releaseFile.write("Mouse released " + e.getButton() + " times\n");
//       releaseFile.close();
//     } catch (IOException ex) {
//       System.out.println(ex);
//       System.out.println(ex.getMessage());
//     }
//   }

//   public void nativeMouseMoved(NativeMouseEvent e) {
//     try {
//       FileWriter moveFile = new FileWriter("./data/move_tracks.txt", true);

//       moveFile.write("Mouse moved" + e.getX() + " " + e.getY() + "\n");
//       moveFile.close();

//     } catch (IOException ex) {
//       System.out.println(ex);
//       System.out.println(ex.getMessage());
//     }
//   }

//   public void nativeMouseDragged(NativeMouseEvent e) {
//     try {
//       FileWriter dragFile = new FileWriter("./data/drag_tracks.txt", true);

//       dragFile.write("Mouse dragged " + e.getX() + ", " + e.getY() + "\n");
//       dragFile.close();
//     } catch (IOException ex) {
//       System.out.println(ex);
//       System.out.println(ex.getMessage());
//     }
//   }
// }

// public class App extends JComponent {
//   public void paint(Graphics g) {
//     try {
//       File myFile = new File("./data/move_tracks.txt");
//       Scanner myReader = new Scanner(myFile);

//       while (myReader.hasNextLine()) {
//       }

//       myReader.close();
//     } catch (Exception e) {
//       System.out.println(e.getMessage());
//     }
//   }

//   public static void main(String[] args) throws Exception {
//     try {
//       GlobalScreen.registerNativeHook();
//     } catch (NativeHookException ex) {
//       System.out.println("JNative hook could not be registered");
//       System.out.println(ex.getMessage());

//       System.exit(1);
//     }

//     MouseListener mouseListener = new MouseListener();

//     GlobalScreen.addNativeMouseListener(mouseListener);
//     GlobalScreen.addNativeMouseMotionListener(mouseListener);

//     // JFrame window = new JFrame();

//     // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     // window.setBounds(30, 30, 200, 200);
//     // window.getContentPane().add(new App());
//     // window.setVisible(true);
//   }
// }

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.FileWriter;
import java.io.IOException;

class MouseGUI extends Frame implements MouseMotionListener {
  static JLabel label;
  static FileWriter fileWriter;

  public static void main(String[] args) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    JFrame f = new JFrame("MouseMotionListener");
    f.setSize(width, height);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    label = new JLabel("No event ");

    MouseGUI m = new MouseGUI();
    f.addMouseMotionListener(m);

    panel.add(label);
    f.add(panel);
    f.setVisible(true);
  }

  public void mouseDragged(MouseEvent e) {
    try {
      fileWriter = new FileWriter("./data/drag_tracks", true);
      fileWriter.write(e.getX() + " " + e.getY() + "\n");
      label.setText("mouse is dragged through point "
          + e.getX() + " " + e.getY());

      fileWriter.close();
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }

  public void mouseMoved(MouseEvent e) {
  }
}