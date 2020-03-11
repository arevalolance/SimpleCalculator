import javax.swing.*;
import java.awt.*;

class Window {
    JFrame frame;
    JPanel buttonPanel;
    JPanel inputPanel;
    JPanel resultPanel;
    JPanel mainPanel;
    public JTextField inputField;
    JTextField runningResultField;
    JButton[] operators = new JButton[]{
            new JButton("DARK"),
            new JButton("CE"),
            new JButton("C"),
            new JButton("x"),
            new JButton("("),
            new JButton(")"),
            new JButton("%"),
            new JButton("1/x"),
            new JButton("x²"),
            new JButton("xⁿ"),
            new JButton("|x|"),
            new JButton("/"),
            new JButton("7"),
            new JButton("8"),
            new JButton("9"),
            new JButton("*"),
            new JButton("4"),
            new JButton("5"),
            new JButton("6"),
            new JButton("-"),
            new JButton("1"),
            new JButton("2"),
            new JButton("3"),
            new JButton("+"),
            new JButton("+/-"),
            new JButton("0"),
            new JButton("."),
            new JButton("=")
    };
    ;

    final int LIGHT_BUTTON_OPERATORS_COLOR = 0xdcdde1;
    final int LIGHT_WINDOWS_BACKGROUND = 0xe6e6e6;
    final int LIGHT_MODE_TEXT = 0x00000;

    final int DARK_MODE_TEXT = 0xecf0f1;
    final int DARK_WINDOWS_BACKGROUND = 0x1f1f1f;
    final int DARK_BUTTON_OPERATORS_COLOR = 0x0131313;


    void setButtonPanel() {
        buttonPanel.setLayout(new GridLayout(7, 4, 2, 2));

        for (JButton button : operators) {
            button.setBackground(new Color(LIGHT_BUTTON_OPERATORS_COLOR));
            button.setBorder(null);
            button.setPreferredSize(new Dimension(100, 75));
            button.setFont(new Font("Roboto", Font.BOLD, 15));
            operators[operators.length - 1].setBackground(new Color(0x3498db));
            buttonPanel.add(button);
        }

    }

    void setTextPanel() {
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

    void setFrame() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setMinimumSize(new Dimension(300, 600));
        frame.setIconImage(new ImageIcon("assets/calculator_icon.png").getImage());
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
