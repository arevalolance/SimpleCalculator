package Calculator;

import Calculator.InputHandlers.DataHandling;

import javax.swing.*;

/**
 * {@code Calculator.Executable} is the main class for executing the whole program.
 * This initiates all of the components in the {@code Calculator.InputHandlers.Window} class.
 *
 * @author Lance Gabrielle S Arevao
 */
public class Executable extends DataHandling {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataHandling window = new DataHandling();
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
