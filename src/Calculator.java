import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Calculator extends Window {
    private StringBuilder input = new StringBuilder();
    private StringBuilder output = new StringBuilder();

    private static boolean darkMode = false;

    /**
     * This method is used for toggling the dark mode option found in the Calculator Program.
     */
    private void darkModeToggle() {
        operators[0].addActionListener(e -> {
            darkMode = !darkMode; // --> boolean that negates the current state when pressed
            if (darkMode) {
                setButtonColors(DARK_BUTTON_OPERATORS_COLOR, DARK_MODE_TEXT, DARK_WINDOWS_BACKGROUND, DARK_WINDOWS_BACKGROUND, DARK_MODE_TEXT);
            } else {
                setButtonColors(LIGHT_BUTTON_OPERATORS_COLOR, LIGHT_MODE_TEXT, LIGHT_WINDOWS_BACKGROUND, LIGHT_WINDOWS_BACKGROUND, LIGHT_MODE_TEXT);
                operators[operators.length - 1].setBackground(new Color(DARK_MODE_TEXT));
                operators[operators.length - 1].setForeground(new Color(DARK_WINDOWS_BACKGROUND));
            }
        });
    }

    /**
     * This sets the action/process of the button for clearing the last entry found in the text field.
     */
    private void clearLastEntryButton() {
        operators[1].addActionListener(e -> {
            try {
                input.delete(0, input.toString().length() - 1);
                inputField.setText("0");
            } catch (Exception ex) {
                System.out.println("no number left.");
            }
        });
    }

    /**
     * This sets the action/process of the button for clearing both the input and output text fields.
     */
    private void clearAllButton() {
        operators[2].addActionListener(e -> {
            input.delete(0, input.toString().length());
            output.delete(0, output.toString().length());

            inputField.setText("0");
            runningResultField.setText("");
        });
    }
    /**
     * This sets the action/process of the button for clearing the last character found in the text field.
     */
    private void clearLastCharacterButton() {
        operators[3].addActionListener(e -> {
            try {
                inputField.setText(input.deleteCharAt(input.toString().length() - 1).toString());
            } catch (Exception ex) {
                System.out.println("no number left");
            }
        });
    }
    /**
     * This sets the action/process of the button for inputting a opening parenthesis which is considered as an operator.
     */
    private void openParenthesisButton() {
        operators[4].addActionListener(e -> {
            if (input.toString().equalsIgnoreCase("0"))
                input.delete(0, input.toString().length());

            String series = output.append(input.toString()).append('(').append(" ").toString();

            input.delete(0, input.toString().length());

            inputField.setText("0");
            runningResultField.setText(series);
        });
    }

    /**
     * This sets the action/process of the button for inputting a closing parenthesis which is considered as an operator.
     */
    private void closingParenthesisButton() {
        operators[5].addActionListener(e -> {
            if (input.toString().equalsIgnoreCase("0"))
                input.delete(0, input.toString().length());

            String series = output.append(input.toString()).append(" ").append(')').toString();

            input.delete(0, input.toString().length());

            inputField.setText("0");
            runningResultField.setText(series);
        });
    }

    /**
     * This sets the action/process of the button for computing the given data in the TextField into its Percentage form.
     */
    private void percentButton() {
        operators[6].addActionListener(e -> {
            String percentage = toString(computePercentage(parseNumber(input.toString())));
            inputField.setText(percentage);
            input.delete(0, input.toString().length());
            input.append(percentage);
        });
    }
    /**
     * This sets the action/process of the button which converts the number in the textfield into its Mathematical Inverse
     */
    private void inverseButton() {
        operators[7].addActionListener(e -> {
            double a = parseNumber(inputField.getText());

            input.delete(0, input.toString().length());

            inputField.setText(toString(inverse(a)));
        });
    }

    /**
     * This sets the action/process of the button for inputting a n raised to 2 incidence in the series.
     */
    private void squaredButton() {
        operators[8].addActionListener(e -> {
            if (input.toString().equalsIgnoreCase("0"))
                input.delete(0, input.toString().length());

            String series = output.append(input.toString()).append(" ").append('^').append(" ").append("2").toString();

            input.delete(0, input.toString().length());

            inputField.setText("0");
            runningResultField.setText(series);
        });
    }

    /**
     * This sets the action/process of the button for inputting a n raised to n incidence in the series.
     */
    private void raiseToN() {
        operators[9].addActionListener(e -> {
            if (input.toString().equalsIgnoreCase("0"))
                input.delete(0, input.toString().length());

            String series = output.append(input.toString()).append(" ").append('^').append(" ").toString();

            input.delete(0, input.toString().length());

            inputField.setText("0");
            runningResultField.setText(series);
        });
    }

    /**
     * This sets the action/process of the button for converting the value given in the textfield into its absolute value.
     */
    private void absoluteButton() {
        operators[10].addActionListener(e -> inputField.setText(String.valueOf(Math.abs(Integer.parseInt(input.toString())))));
    }

    /**
     * This sets the action/process of the button when inputting a divide operator
     */
    private void divideButton() {
        operators[11].addActionListener(e -> inputOperator('/'));
    }

    /**
     * This sets the action/process of the button when inputting the number 7
     */
    private void sevenButton() {
        operators[12].addActionListener(e -> inputString("7"));
    }

    /**
     * This sets the action/process of the button when inputting the number 8.
     */
    private void eightButton() {
        operators[13].addActionListener(e -> inputString("8"));
    }

    /**
     * This sets the action/process of the button when inputting the number 9.
     */
    private void nineButton() {
        operators[14].addActionListener(e -> inputString("9"));
    }

    /**
     * This sets the action/process of the button when inputting a multiplication operator.
     */
    private void multiplyButton() {
        operators[15].addActionListener(e -> inputOperator('*'));
    }
    /**
     * This sets the action/process of the button when inputting the number 4.
     */
    private void fourButton() {
        operators[16].addActionListener(e -> inputString("4"));
    }
    /**
     * This sets the action/process of the button when inputting the number 5.
     */
    private void fiveButton() {
        operators[17].addActionListener(e -> inputString("5"));
    }

    /**
     * This sets the action/process of the button when inputting the number 6.
     */
    private void sixButton() {
        operators[18].addActionListener(e -> inputString("6"));
    }

    /**
     * This sets the action/process of the button when inputting a subtraction operator.
     */
    private void subtractButton() {
        operators[19].addActionListener(e -> inputOperator('-'));
    }

    /**
     * This sets the action/process of the button when inputting the number 1.
     */
    private void oneButton() {
        operators[20].addActionListener(e -> inputString("1"));
    }

    /**
     * This sets the action/process of the button when inputting the number 2.
     */
    private void twoButton() {
        operators[21].addActionListener(e -> inputString("2"));
    }

    /**
     * This sets the action/process of the button when inputting the number 3.
     */
    private void threeButton() {
        operators[22].addActionListener(e -> inputString("3"));
    }

    /**
     * This sets the action/process of the button when inputting the addition operator
     */
    private void addButton() {
        operators[23].addActionListener(e -> inputOperator('+'));
    }

    /**
     * This sets the action/process of the button when you want to negate the number inside the text field.
     */
    private void negateButton() {
        operators[24].addActionListener(e -> inputField.setText(toString(negate((int) parseNumber(inputField.getText())))));
    }

    /**
     * This sets the action/process of the button when inputting the number 0.
     */
    private void zeroButton() {
        operators[25].addActionListener(e -> {
            if (!input.toString().equalsIgnoreCase("0")) {
                inputString("0");
            }
        });
    }

    /**
     * This sets the action/process of the button when inputting a decimal character.
     */
    private void decimalButton() {
        operators[26].addActionListener(e -> inputString("."));
    }

    /**
     * This sets the action/process of the button when you want to find the result of the series that you have inputted.
     */
    private void resultButton() {
        operators[27].addActionListener(e -> {
            showResult();
        });
    }

    private void inputString(String token) {
        if (input.toString().equalsIgnoreCase("0")) {
            input.delete(0, input.toString().length());
        }
        inputField.setText(input.append(token).toString());
    }

    private void inputOperator(char token) {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append(token).append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    private void setButtonColors(int button_operators_color, int button_numbers_color, int windows_background, int buttons_panel, int mode_text) {
        for (JButton lightMode : operators) {
            lightMode.setBackground(new Color(button_operators_color));
            lightMode.setForeground(new Color(button_numbers_color));
        }

        mainPanel.setBackground(new Color(windows_background));
        buttonPanel.setBackground(new Color(buttons_panel));

        inputField.setBackground(new Color(windows_background));
        inputField.setForeground(new Color(mode_text));

        runningResultField.setBackground(new Color(windows_background));
        runningResultField.setForeground(new Color(mode_text));
    }

    void showResult(){
        try {
            String series = output.append(inputField.getText()).toString();
            System.out.println(series);
            Double result = Operation.computePostFix(Operation.toPostFix(series));

            output.delete(0, output.toString().length());
            input.delete(0, input.toString().length());

            inputField.setText(input.append(result).toString());
            runningResultField.setText("");
        } catch (Exception ex) {
            output.delete(0, output.toString().length());
            input.delete(0, input.toString().length());

            inputField.setText("Syntax Error");
            runningResultField.setText("");
        }
    }

    class KeyHandlers implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_9 && e.getKeyCode() == KeyEvent.VK_SHIFT)
                inputString(" ( ");
            if (e.getKeyCode() == KeyEvent.VK_0 && e.getKeyCode() == KeyEvent.VK_SHIFT)
                inputString(" ) ");
            if (e.getKeyCode() == KeyEvent.VK_DIVIDE || e.getKeyCode() == KeyEvent.VK_SLASH)
                inputOperator('/');
            if (e.getKeyCode() == KeyEvent.VK_ASTERISK || e.getKeyCode() == KeyEvent.VK_MULTIPLY)
                inputOperator('*');
            if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT)
                inputOperator('-');
            if (e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_PLUS)
                inputOperator('+');
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_EQUALS)
                showResult();
            if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
                inputString("1");
            if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
                inputString("2");
            if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
                inputString("3");
            if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
                inputString("4");
            if (e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
                inputString("5");
            if (e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
                inputString("6");
            if (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
                inputString("7");
            if (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
                inputString("8");
            if (e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
                inputString("9");
            if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
                inputString("0");
            if (e.getKeyCode() == KeyEvent.VK_PERIOD || e.getKeyCode() == KeyEvent.VK_DECIMAL)
                inputString(".");
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                try {
                    inputField.setText(input.deleteCharAt(input.toString().length() - 1).toString());
                } catch (Exception ex) {
                    System.out.println("no number left");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                input.delete(0, input.toString().length());
                output.delete(0, output.toString().length());

                inputField.setText("0");
                runningResultField.setText("");
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void buttonHandlers() {
        clearLastEntryButton();
        clearAllButton();
        clearLastCharacterButton();
        openParenthesisButton();
        closingParenthesisButton();
        percentButton();
        inverseButton();
        squaredButton();
        raiseToN();
        absoluteButton();
        divideButton();
        sevenButton();
        eightButton();
        nineButton();
        multiplyButton();
        fourButton();
        fiveButton();
        sixButton();
        subtractButton();
        oneButton();
        twoButton();
        threeButton();
        addButton();
        negateButton();
        zeroButton();
        decimalButton();
        resultButton();
    }

    private void initComponents() {
        frame = new JFrame("Calculator");
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        resultPanel = new JPanel();
        inputField = new JTextField("0");
        runningResultField = new JTextField();

        darkModeToggle();

        setTextPanel();
        setButtonPanel();
        setFrame();

        buttonHandlers();
        KeyHandlers keyHandlers = new KeyHandlers();
        for (JButton button : operators)
            button.addKeyListener(keyHandlers);
        buttonPanel.addKeyListener(keyHandlers);
        mainPanel.addKeyListener(keyHandlers);
        inputField.addKeyListener(keyHandlers);
        runningResultField.addKeyListener(keyHandlers);
        frame.addKeyListener(keyHandlers);

    }

    private double computePercentage(double num){
        return num / 100;
    }

    private double inverse(double num){
        return 1 / num;
    }

    private double negate(int num){
        return Math.negateExact(num);
    }

    private String toString(Double num){
        return Double.toString(num);
    }

    private static double parseNumber(String token){
        double parsed = 0;

        try {
            parsed = Double.parseDouble(token);
        }catch (Exception e){
            System.out.println("not a number");
        }

        return parsed;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator window = new Calculator();
            try {
                window.initComponents();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
