package Calculator.InputHandlers;

import Calculator.Compute.Operation;

import javax.swing.*;
import java.awt.*;

public class DataHandling extends Window implements DataIO {

    /**
     * Acts as a container for the user's input on the calculator.
     */
    StringBuilder input = new StringBuilder();

    /**
     * Acts as a container for the whole series inputted by the user.
     * This is used for producing the final output.
     */
    StringBuilder output = new StringBuilder();


    /**
     * This method is used for showing the Result of the inputted series. It also carries out an error in case a Syntax error
     * occured during the typing of the problem.
     */
    public void showResult() {
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


    /**
     * This method is used for inputting a string inside the text field. It is done by setting the input text field's text
     * to the string made through the string builder. Each token in the string is separated by a space.
     *
     * @param token String to be appended
     */
    public void inputString(String token) {
        if (input.toString().equalsIgnoreCase("0")) {
            input.delete(0, input.toString().length());
        }
        System.out.println(token);
        inputField.setText(input.append(token).toString());
    }

    /**
     * This method is used for inputting a certain operator into the field. It is done by pressing any of the given operators
     * and it automatically puts it in the {@code runningResultField} which is used for the final computations.
     *
     * @param token a given operator
     */
    public void inputOperator(String token) {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append(token).append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This variable contains the state of the window's theme.
     * <p>
     * {@code darkMode} = true means that it's in dark mode
     * {@code darkMode} = false means that it's in light mode
     */
    private static boolean darkMode = false;

    /**
     * This method is used for toggling the dark mode option found in the Calculator.Calculator Program.
     */
    public void darkModeToggle() {
        darkMode = !darkMode; // --> boolean that negates the current state when pressed
        if (darkMode) {
            setButtonColors(DARK_MODE_TEXT, DARK_WINDOWS_BACKGROUND, DARK_BUTTON_OPERATORS_COLOR, DARK_MODE_TEXT, DARK_WINDOWS_BACKGROUND, DARK_WINDOWS_BACKGROUND, DARK_MODE_TEXT);
            operators[operators.length - 1].setBackground(DARK_MODE_TEXT);
            operators[operators.length - 1].setForeground(DARK_WINDOWS_BACKGROUND);

            namePanel.setBackground(DARK_WINDOWS_BACKGROUND);
            creatorLabel.setForeground(DARK_MODE_TEXT);
        } else {
            setButtonColors(Color.WHITE, LIGHT_MODE_TEXT, LIGHT_BUTTON_OPERATORS_COLOR, LIGHT_MODE_TEXT, LIGHT_WINDOWS_BACKGROUND, LIGHT_WINDOWS_BACKGROUND, LIGHT_MODE_TEXT);
            operators[operators.length - 1].setBackground(new Color(0x3498db));

            namePanel.setBackground(LIGHT_WINDOWS_BACKGROUND);
            creatorLabel.setForeground(LIGHT_MODE_TEXT);
        }
    }

    /**
     * This sets the action/process of the button for clearing the last entry found in the text field.
     */
    public void clearLastEntry() {
        try {
            input.delete(0, input.toString().length() - 1);
            inputField.setText("0");
        } catch (Exception ex) {
            System.out.println("no number left.");
        }
    }

    /**
     * This sets the action/process of the button for clearing both the input and output text fields.
     */
    public void clearAll() {
        input.delete(0, input.toString().length());
        output.delete(0, output.toString().length());

        inputField.setText("0");
        runningResultField.setText("");
    }

    /**
     * This sets the action/process of the button for clearing the last character found in the text field.
     */
    public void clearLastCharacter() {
        try {
            inputField.setText(input.deleteCharAt(input.toString().length() - 1).toString());
        } catch (Exception ex) {
            System.out.println("no number left");
        }
    }

    /**
     * This sets the action/process of the button for inputting a opening parenthesis which is considered as an operator.
     */
    public void openParenthesis() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append('(').append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This sets the action/process of the button for inputting a closing parenthesis which is considered as an operator.
     */
    public void closingParenthesis() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append(')').toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This sets the action/process of the button for computing the given data in the TextField into its Percentage form.
     */
    public void percent() {
        String percentage = Double.toString(computePercentage(parseNumber(input.toString())));
        inputField.setText(percentage);
        input.delete(0, input.toString().length());
        input.append(percentage);
    }

    /**
     * This sets the action/process of the button which converts the number in the textfield into its Mathematical Inverse
     */
    public void inverse() {
        double a = inverse(parseNumber(inputField.getText()));

        input.delete(0, input.toString().length());

        input.append(a);
        inputField.setText(input.toString());
    }

    /**
     * This sets the action/process of the button for inputting a n raised to 2 incidence in the series.
     */
    public void squared() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append('^').append(" ").append("2").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This sets the action/process of the button for inputting a n raised to n incidence in the series.
     */
    public void raiseToN() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append('^').append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This sets the action/process of the button for converting the value given in the textfield into its absolute value.
     */
    public void absolute() {
        double absolute = Math.abs(parseNumber(input.toString()));

        input.delete(0, input.toString().length());
        input.append(absolute);
        inputField.setText(input.toString());
    }

    /**
     * This sets the action/process of the button when you want to negate the number inside the text field.
     */
    public void negate() {
        double negated = negate(parseNumber(input.toString()));

        input.delete(0, input.toString().length());

        input.append(negated);
        inputField.setText(input.toString());
    }

    /**
     * This sets the action/process of the button when you want to find the result of the series that you have inputted.
     */
    public void result() {
        operators[27].addActionListener(e -> showResult());
    }


    /**
     * <n>This method is sued for changing the color theme of the Calculator.Calculator program.</n>
     * <n>The following components are changed:</n>
     * <n>Button's Background and Text Color</n>
     * <n>Main Panel, Button Panel, Input and Output Text Panel</n>
     * <n>Input and Running Result Text Fields</n>
     *
     * @param number_button_color      color for numbers
     * @param button_operators_color   color for the buttons
     * @param button_text_color        color for the button's text
     * @param windows_background_color background color
     * @param buttons_panel_color      buttons background color
     * @param text_color               color of the text
     */
    private void setButtonColors(Color number_button_color, Color number_text_color, Color button_operators_color, Color button_text_color, Color windows_background_color, Color buttons_panel_color, Color text_color) {
        for (JButton button : operators) {
            if (Character.isDigit(button.getText().charAt(0))) {
                button.setBackground(number_button_color);
                button.setForeground(number_text_color);
            } else {
                button.setBackground(button_operators_color);
                button.setForeground(button_text_color);
            }
        }

        mainPanel.setBackground(windows_background_color);
        buttonPanel.setBackground(buttons_panel_color);

        inputField.setBackground(windows_background_color);
        inputField.setForeground(text_color);

        runningResultField.setBackground(windows_background_color);
        runningResultField.setForeground(text_color);
    }

    /**
     * <n>This computes the percentage of a given number.</n>
     * <n>Formula: num divided by 100 ( num / 100 )</n>
     *
     * @param num to be converted
     * @return percentage form
     */
    public double computePercentage(double num) {
        return num / 100;
    }

    /**
     * <n>This converts a given number into its mathematical inverse.</n>
     * <n>Formula: 1 divided by num ( 1 / num )</n>
     *
     * @param num to be converted
     * @return mathematical inverse
     */
    public double inverse(double num) {
        return 1 / num;
    }

    /**
     * <n>This negates a given number into its opposite sign.</n>
     * <n>If a number is positive then it is converted into a negative number, otherwise it will be a positive number.</n>
     *
     * @param num to be converted
     * @return sign negated
     */
    public double negate(double num) {
        return num * -1;
    }

    /**
     * <n>This is used for parsing a given string which is assumed to be a valid number.</n>
     * <n>Algorithm:</n>
     * <n>1. A given token is tried for parsing into a double</n>
     * <n>2. In case the given token is not a number and the parsing process failed, It will print out an error</n>
     * <n>3. If it is a valid number, it will return the token into a data type of a double.</n>
     *
     * @param token to be converted
     * @return data type double
     */
    public static double parseNumber(String token) {
        double parsed = 0;

        try {
            parsed = Double.parseDouble(token);
        } catch (Exception e) {
            System.out.println("not a number");
        }

        return parsed;
    }


    /**
     * This starts up and creates all of the required objects for the GUI and adds all of the needed Listeners in order for the
     * program to function very well.
     */
    public void initComponents() {
        frame = new JFrame("Calculator");
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        resultPanel = new JPanel();
        inputField = new JTextField("0");
        runningResultField = new JTextField();
        subPanel = new JPanel();
        namePanel = new JPanel();
        creatorLabel = new JLabel();

        setNamePanel();
        setTextPanel();
        setButtonPanel();
        setFrame();

        ButtonHandling b = new ButtonHandling();
        b.buttonHandlers();

        KeyHandling keyHandlers = new KeyHandling();
        for (JButton button : operators)
            button.addKeyListener(keyHandlers);
        buttonPanel.addKeyListener(keyHandlers);
        mainPanel.addKeyListener(keyHandlers);
        inputField.addKeyListener(keyHandlers);
        runningResultField.addKeyListener(keyHandlers);
        frame.addKeyListener(keyHandlers);

    }
}
