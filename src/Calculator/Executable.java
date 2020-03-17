package Calculator;

import Calculator.InputHandlers.ButtonHandling;
import Calculator.InputHandlers.KeyHandling;

import javax.swing.*;

/**
 * {@code Calculator.Executable} is the main class for executing the whole program.
 * This initiates all of the components in the {@code Calculator.Window} class.
 *
 * @author Lance Gabrielle S Arevao
 */
public class Executable extends ButtonHandling {

    /**
     * This starts up and creates all of the required objects for the GUI and adds all of the needed Listeners in order for the
     * program to function very well.
     */
    private void initComponents() {
        frame = new JFrame("Calculator");
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        resultPanel = new JPanel();
        inputField = new JTextField("0");
        runningResultField = new JTextField();
        subPanel = new JPanel();

        darkModeToggle();

        setNamePanel();
        setTextPanel();
        setButtonPanel();
        setFrame();

        buttonHandlers();
        KeyHandling keyHandlers = new KeyHandling();
        for (JButton button : operators)
            button.addKeyListener(keyHandlers);
        buttonPanel.addKeyListener(keyHandlers);
        mainPanel.addKeyListener(keyHandlers);
        inputField.addKeyListener(keyHandlers);
        runningResultField.addKeyListener(keyHandlers);
        frame.addKeyListener(keyHandlers);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Executable window = new Executable();
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
