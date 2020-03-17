package Calculator.InputHandlers;

import Calculator.Compute.Operation;

import javax.swing.*;
import java.awt.*;

/**
 * <p>{@code Calculator.Calculator} holds all of the necessary processes needed for the program
 * to run. This class contains all of the key bindings, button handlers, computing
 * process ( basic computings ) and the initialization of the components.</p>
 *
 * <p>In regards to the algorithm used for computing the series inputted following the PEMDAS rule
 * Please see {@link Operation}</p>
 *
 * @author Lance Gabrielle S Arevalo
 */
public class ButtonHandling extends DataHandling {

    /**
     * This variable contains the state of the window's theme.
     *
     * {@code darkMode} = true means that it's in dark mode
     * {@code darkMode} = false means that it's in light mode
     */
    private static boolean darkMode = false;

    /**
     * This method is used for toggling the dark mode option found in the Calculator.Calculator Program.
     */
    protected void darkModeToggle() {
        operators[0].addActionListener(e -> {
            darkMode = !darkMode; // --> boolean that negates the current state when pressed
            if (darkMode) {
                setButtonColors(DARK_BUTTON_OPERATORS_COLOR, DARK_MODE_TEXT, DARK_WINDOWS_BACKGROUND, DARK_WINDOWS_BACKGROUND, DARK_MODE_TEXT);
                operators[operators.length - 1].setBackground(DARK_MODE_TEXT);
                operators[operators.length - 1].setForeground(DARK_WINDOWS_BACKGROUND);

                namePanel.setBackground(DARK_WINDOWS_BACKGROUND);
                creatorLabel.setForeground(DARK_MODE_TEXT);
            } else {
                setButtonColors(LIGHT_BUTTON_OPERATORS_COLOR, LIGHT_MODE_TEXT, LIGHT_WINDOWS_BACKGROUND, LIGHT_WINDOWS_BACKGROUND, LIGHT_MODE_TEXT);
                operators[operators.length - 1].setBackground(new Color(0x3498db));

                namePanel.setBackground(LIGHT_WINDOWS_BACKGROUND);
                creatorLabel.setForeground(LIGHT_MODE_TEXT);
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
            String percentage = Double.toString(computePercentage(parseNumber(input.toString())));
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
            double a = inverse(parseNumber(inputField.getText()));

            input.delete(0, input.toString().length());

            input.append(a);
            inputField.setText(input.toString());
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
        operators[10].addActionListener(e -> {
            double absolute = Math.abs(parseNumber(input.toString()));

            input.delete(0, input.toString().length());
            input.append(absolute);
            inputField.setText(input.toString());
        });
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
        operators[24].addActionListener(e -> {
            double negated = negate(parseNumber(input.toString()));

            input.delete(0, input.toString().length());

            input.append(negated);
            inputField.setText(input.toString());
        });
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
        operators[27].addActionListener(e -> showResult());
    }



    /**
     * <n>This method is sued for changing the color theme of the Calculator.Calculator program.</n>
     * <n>The following components are changed:</n>
     * <n>Button's Background and Text Color</n>
     * <n>Main Panel, Button Panel, Input and Output Text Panel</n>
     * <n>Input and Running Result Text Fields</n>
     *
     * @param button_operators_color color for the buttons
     * @param button_text_color      color for the button's text
     * @param windows_background_color     background color
     * @param buttons_panel_color          buttons background color
     * @param text_color              color of the text
     */
    private void setButtonColors(Color button_operators_color, Color button_text_color, Color windows_background_color, Color buttons_panel_color, Color text_color) {
        for (JButton lightMode : operators) {
            lightMode.setBackground(button_operators_color);
            lightMode.setForeground(button_text_color);
        }

        mainPanel.setBackground(windows_background_color);
        buttonPanel.setBackground(buttons_panel_color);

        inputField.setBackground(windows_background_color);
        inputField.setForeground(text_color);

        runningResultField.setBackground(windows_background_color);
        runningResultField.setForeground(text_color);
    }



    /**
     * This just simply calls all of the methods needed for the actions of every button.
     */
    protected void buttonHandlers() {
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

    /**
     * <n>This computes the percentage of a given number.</n>
     * <n>Formula: num divided by 100 ( num / 100 )</n>
     *
     * @param num to be converted
     * @return percentage form
     */
    private double computePercentage(double num) {
        return num / 100;
    }

    /**
     * <n>This converts a given number into its mathematical inverse.</n>
     * <n>Formula: 1 divided by num ( 1 / num )</n>
     *
     * @param num to be converted
     * @return mathematical inverse
     */
    private double inverse(double num) {
        return 1 / num;
    }

    /**
     * <n>This negates a given number into its opposite sign.</n>
     * <n>If a number is positive then it is converted into a negative number, otherwise it will be a positive number.</n>
     *
     * @param num to be converted
     * @return sign negated
     */
    private double negate(double num) { return num * -1;}

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
