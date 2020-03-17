package Calculator.InputHandlers;

import Calculator.InputHandlers.ButtonHandling;
import Calculator.InputHandlers.KeyHandling;

import javax.swing.*;
import java.awt.*;

/**
 * {@code Calculator.InputHandlers.Window} is a class where all of the GUI components are created. This class contains all of my
 * {@code JPanel}, {@code JTextField}, {@code JButton} components are created and added into the
 * {@code JFrame}.
 * <p>
 * Most of the Frontend components are created here. Starting from the Buttons and their proper Labels to the Colors
 * of each Component that can be found in the Program. In case there is something to be changed in how the GUI Looks,
 * Tweak some of the properties that can be found in here.
 * <p>
 * Each of the Components initialization can be found in their proper methods.
 *
 * @author Lance Gabrielle S Arevalo
 */
public class Window {
    public JLabel creatorLabel;
    public JFrame frame;
    public JPanel buttonPanel;
    public JPanel inputPanel;
    public JPanel resultPanel;
    public JPanel mainPanel;
    public JPanel namePanel;
    public JPanel subPanel;
    public JTextField inputField;
    public JTextField runningResultField;
    public JButton[] operators = new JButton[]{
            new JButton("DARK"),
            new JButton("π"),
            new JButton("CE"),
            new JButton("C"),
            new JButton("x"),

            new JButton("x²"),
            new JButton("xⁿ"),
            new JButton("sin"),
            new JButton("cos"),
            new JButton("tan"),

            new JButton("("),
            new JButton(")"),
            new JButton("√"),
            new JButton("ⁿ√"),
            new JButton("/"),

            new JButton("log"),
            new JButton("7"),
            new JButton("8"),
            new JButton("9"),
            new JButton("*"),

            new JButton("log" + ("\\U+2093") + "y"),
            new JButton("4"),
            new JButton("5"),
            new JButton("6"),
            new JButton("-"),

            new JButton("e"),
            new JButton("1"),
            new JButton("2"),
            new JButton("3"),
            new JButton("+"),

            new JButton("ln"),
            new JButton("+/-"),
            new JButton("0"),
            new JButton("."),
            new JButton("=")
    };

    public final Color LIGHT_BUTTON_OPERATORS_COLOR = new Color(0xdcdde1);
    public final Color LIGHT_WINDOWS_BACKGROUND = new Color(0xe6e6e6);
    public final Color LIGHT_MODE_TEXT = new Color(0x00000);

    public final Color DARK_MODE_TEXT = new Color(0xecf0f1);
    public final Color DARK_WINDOWS_BACKGROUND = new Color(0x1f1f1f);
    public final Color DARK_BUTTON_OPERATORS_COLOR = new Color(0x0131313);


    public void setButtonPanel() {
        buttonPanel.setLayout(new GridLayout(7, 5, 2, 2));

        for (JButton button : operators) {
            button.setBackground(LIGHT_BUTTON_OPERATORS_COLOR);
            button.setBorder(null);
            button.setPreferredSize(new Dimension(100, 75));
            button.setFont(new Font("Roboto", Font.BOLD, 15));

            buttonPanel.add(button);
        }

        operators[operators.length - 1].setBackground(new Color(0x3498db));

    }

    public void setTextPanel() {
        inputPanel = new JPanel(new GridLayout(1, 1));
        resultPanel = new JPanel(new GridLayout(1, 1));

        inputField.setFont(new Font("Roboto", Font.BOLD, 50));
        runningResultField.setFont(new Font("Roboto", Font.ITALIC, 15));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        runningResultField.setHorizontalAlignment(SwingConstants.RIGHT);

        inputField.setBorder(null);
        inputField.setEditable(false);
        runningResultField.setBorder(null);
        runningResultField.setEditable(false);

        inputField.setPreferredSize(new Dimension(400, 100));
        resultPanel.setPreferredSize(new Dimension(400, 30));

        inputPanel.add(inputField);
        resultPanel.add(runningResultField);
    }

    public void setNamePanel() {
        namePanel = new JPanel();
        creatorLabel = new JLabel("Arevalo, Lance Gabrielle S.");

        creatorLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
        creatorLabel.setForeground(LIGHT_MODE_TEXT);

        namePanel.setBackground(LIGHT_WINDOWS_BACKGROUND);

        namePanel.add(creatorLabel);
    }

    public void setFrame() {
        subPanel.setLayout(new BorderLayout());
        subPanel.add(buttonPanel, BorderLayout.NORTH);
        subPanel.add(namePanel, BorderLayout.SOUTH);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.NORTH);
        mainPanel.add(subPanel, BorderLayout.SOUTH);

        frame.setMinimumSize(new Dimension(300, 600));
        frame.setIconImage(new ImageIcon("assets/calculator_icon.png").getImage());
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



}
