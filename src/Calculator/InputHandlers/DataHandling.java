package Calculator.InputHandlers;

import Calculator.Compute.Operation;
import Calculator.UI.Window;

import javax.swing.*;
import java.awt.*;

/**
 * {@code DataHandling} class contains all of the data processing for the Calculator.
 * This includes the input and output of the user which are the data, operations, etc.
 * Using this class can give you a lot of Functionality when it comes to computing.
 * Some of these functionality may compute automatically a given input and some can
 * let you input a constant number like the constant {@code PI} or {@code E}.
 *
 * <p>The whole data handling process of this class relies on the two {@code StringBuilder}
 * object created. These two has their own function. {@code input} handles all of the given
 * instruction by the user whilst the {@code output} converts it into a space separated series
 * which will then be used for computing.
 *
 * <p>For the computing process, {@see Calculator.Compute.Operator} for more information.</p>
 *
 * @author Lance Gabrielle S Arevalo
 * @see Calculator.Compute.Operator
 * @see Calculator.InputHandlers.UserInputs
 */
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
            String series;
            if (!inputField.getText().equals("0")) {
                series = output.append(inputField.getText()).toString();
            } else {
                series = output.toString();
            }
            Double result = Operation.computePostFix(Operation.toPostFix(series));

            output.delete(0, output.toString().length());
            input.delete(0, input.toString().length());

            inputField.setText(input.append(result).toString());
            runningResultField.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
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
    void darkModeToggle() {
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
    void clearLastEntry() {
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
    void clearAll() {
        input.delete(0, input.toString().length());
        output.delete(0, output.toString().length());

        inputField.setText("0");
        runningResultField.setText("");
    }

    /**
     * This sets the action/process of the button for clearing the last character found in the text field.
     */
    void clearLastCharacter() {
        try {
            inputField.setText(input.deleteCharAt(input.toString().length() - 1).toString());
        } catch (Exception ex) {
            System.out.println("no number left");
        }
    }

    /**
     * This sets the action/process of the button for inputting a opening parenthesis which is considered as an operator.
     */
    void openParenthesis() {
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
    void closingParenthesis() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append(')').toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This is used for inputting an operator that only needs one digit for computing.
     * Operations like trigonometric functions and logarithmic computations are applicable
     * for this method.
     *
     * @param token an operator that only needs a single digit for computing
     */
    void inputSingleDigitOperator(String token) {
        if (output.length() > -1 || Character.isDigit(output.toString().charAt(output.toString().length() - 2))) {
            if (input.toString().equalsIgnoreCase("0"))
                input.delete(0, input.toString().length());

            String series = output.append(input.toString()).append(token).append(" ").toString();

            input.delete(0, input.toString().length());

            inputField.setText("0");
            runningResultField.setText(series);
        } else {
            inputOperator(token);
        }
    }

    /**
     * This sets the action/process of the button for inputting a n raised to 2 incidence in the series.
     */
    void squared() {
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
    void raiseToN() {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append('^').append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }

    /**
     * This sets the action/process of the button when you want to negate the number inside the text field.
     */
    void negate() {
        double negated = negate(parseNumber(input.toString()));

        input.delete(0, input.toString().length());

        input.append(negated);
        inputField.setText(input.toString());
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
     * <n>This negates a given number into its opposite sign.</n>
     * <n>If a number is positive then it is converted into a negative number, otherwise it will be a positive number.</n>
     *
     * @param num to be converted
     * @return sign negated
     */
    private double negate(double num) {
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
    private static double parseNumber(String token) {
        double parsed = 0;

        try {
            parsed = Double.parseDouble(token);
        } catch (Exception e) {
            System.out.println("not a number");
        }

        return parsed;
    }


}
