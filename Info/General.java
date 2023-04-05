package Info;

// imports from the java library
import java.awt.Font;
import java.awt.Color;
import java.awt.Window;

/**
 * @author Nikola
 */
public class General {
    // Colour palette
    public static Color WHITE = new Color(255, 255, 255);
    public static Color BLACK = new Color(0, 0, 0);
    public static Color BUTTON_BLUE = new Color(65, 175, 255, 1);

    // Monospaced font declaration (size)
    public static Font font(int size) {
        return new Font("Monospaced", Font.PLAIN, size);
    }

    // Close all windows in the array
    public static void closeAllWindows() {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            window.dispose();
        }
    }

    /* Set the Nimbus look and feel */
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    public static void setNimbusLookAndFeel(Class className) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(className.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(className.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(className.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(className.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }
    }
}