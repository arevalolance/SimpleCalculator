import javax.swing.*;

/**
 * {@code Executable} is the main class for executing the whole program.
 * This initiates all of the components in the {@code Window} class.
 *
 * @author Lance Gabrielle S Arevao
 */
public class Executable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator window = new Calculator();
            try {

                long startTime = System.nanoTime();
                long endTime = System.nanoTime();

                System.out.println("Took " + (endTime - startTime) + "ms");

                window.initComponents();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
