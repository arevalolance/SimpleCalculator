package Calculator.InputHandlers;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInputs extends DataHandling {

    public void buttonHandlers(JButton[] buttons){

        // DARK MODE TOGGLE
        buttons[0].addActionListener(e -> darkModeToggle());

        // INPUT PI
        buttons[1].addActionListener(e -> inputString(Double.toString(Math.PI)));

        // CLEAR LAST ENTRY
        buttons[2].addActionListener(e -> clearLastEntry());

        // CLEAR ALL
        buttons[3].addActionListener(e -> clearAll());

        // CLEAR CHARACTER
        buttons[4].addActionListener(e -> clearLastCharacter());

        // SQUARED
        buttons[5].addActionListener(e -> squared());

        // RAISE TO N
        buttons[6].addActionListener(e -> raiseToN());

        // SIN
        buttons[7].addActionListener(e -> inputOperator("sin"));

        // COS
        buttons[8].addActionListener(e -> inputOperator("cos"));

        // TAN
        buttons[9].addActionListener(e -> inputOperator("tan"));

        // OPEN PARENTHESIS
        buttons[10].addActionListener(e -> openParenthesis());

        // CLOSING PARENTHESIS
        buttons[11].addActionListener(e -> closingParenthesis());

        // ROOT
        buttons[12].addActionListener(e -> inputOperator("√"));

        // NTH ROOT
        buttons[13].addActionListener(e -> inputOperator("ⁿ√"));

        // DIVIDE
        buttons[14].addActionListener(e -> inputOperator("/"));

        // LOGARITHM
        buttons[15].addActionListener(e -> inputOperator("log"));

        // MULLTIPLY
        buttons[19].addActionListener(e -> inputOperator("*"));

        // LOG x
        buttons[20].addActionListener(e -> inputOperator("logx"));

        // SUBTRACT
        buttons[24].addActionListener(e -> inputOperator("-"));

        // E CONSTANT
        buttons[25].addActionListener(e -> inputOperator(Double.toString(Math.E)));

        // ADDITION
        buttons[29].addActionListener(e -> inputOperator("+"));

        // LN
        buttons[30].addActionListener(e -> inputOperator("ln"));

        // NEGATE
        buttons[31].addActionListener(e -> negate());

        // DECIMAL
        buttons[33].addActionListener(e -> inputString("."));

        // SHOW RESULT
        buttons[buttons.length - 1].addActionListener(e -> showResult());

        for (JButton button : operators){
            if (Character.isDigit(button.getText().charAt(0))){
                button.addActionListener(e -> inputString(button.getText()));
            }
        }

    }


    /**
     * This class is used for handling all of the key inputs in the keyboard. Since the text fields are non editable, They key bindings
     * created here are only limited to the numbers and operators available inside the calculator.
     */

    public class KeyHandling implements KeyListener {

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
                inputOperator("/");
            if (e.getKeyCode() == KeyEvent.VK_ASTERISK || e.getKeyCode() == KeyEvent.VK_MULTIPLY)
                inputOperator("*");
            if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT)
                inputOperator("-");
            if (e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_PLUS)
                inputOperator("+");
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
        runningResultField = new JTextField();
        subPanel = new JPanel();
        namePanel = new JPanel();
        creatorLabel = new JLabel();

        setNamePanel();
        setTextPanel();
        setButtonPanel();
        setFrame();

        buttonHandlers(operators);

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
