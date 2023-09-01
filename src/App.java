import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import java.io.FileWriter;
import java.io.IOException;

class App implements NativeMouseInputListener {
  public void nativeMouseClicked(NativeMouseEvent e) {
  }

  public void nativeMousePressed(NativeMouseEvent e) {
  }

  public void nativeMouseReleased(NativeMouseEvent e) {
  }

  public void nativeMouseMoved(NativeMouseEvent e) {
    // try {
    //   FileWriter moveFile = new FileWriter("./data/move_tracks.txt", true);
    //   xCord.add(e.getX());
    //   yCord.add(e.getY());
    //   panel1.repaint();
    //   moveFile.write(e.getX() + " " + e.getY() + "\n");
    //   moveFile.close();

    // } catch (IOException ex) {
    //   System.out.println(ex);
    //   System.out.println(ex.getMessage());
    // }
  }

  public void nativeMouseDragged(NativeMouseEvent e) {
    try {
      FileWriter dragFile = new FileWriter("./data/drag_tracks.txt", true);

      dragFile.write(e.getX() + " " + e.getY() + "\n");
      dragFile.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println(ex.getMessage());
    }
  }

  public static void main(String[] args) {
    try {
      GlobalScreen.registerNativeHook();
    } catch (NativeHookException ex) {
      System.err.println("There was a problem registering the native hook.");
      System.err.println(ex.getMessage());

      System.exit(1);
    }

    App app = new App();

    GlobalScreen.addNativeMouseListener(app);
    GlobalScreen.addNativeMouseMotionListener(app);
  }
}