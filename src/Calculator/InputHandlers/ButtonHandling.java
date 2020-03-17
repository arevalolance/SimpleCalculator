package Calculator.InputHandlers;

import javax.swing.*;

public class ButtonHandling extends DataHandling {

    void buttonHandlers(){

        // DARK MODE TOGGLE
        operators[0].addActionListener(e -> darkModeToggle());

        // INPUT PI
        operators[1].addActionListener(e -> inputString(Double.toString(Math.PI)));

        // CLEAR LAST ENTRY
        operators[2].addActionListener(e -> clearLastEntry());

        // CLEAR ALL
        operators[3].addActionListener(e -> clearAll());

        // CLEAR CHARACTER
        operators[4].addActionListener(e -> clearLastCharacter());

        // SQUARED
        operators[5].addActionListener(e -> squared());

        // RAISE TO N
        operators[6].addActionListener(e -> raiseToN());

        // SIN
        operators[7].addActionListener(e -> inputOperator("sin"));

        // COS
        operators[8].addActionListener(e -> inputOperator("cos"));

        // TAN
        operators[9].addActionListener(e -> inputOperator("tan"));

        // OPEN PARENTHESIS
        operators[10].addActionListener(e -> openParenthesis());

        // CLOSING PARENTHESIS
        operators[11].addActionListener(e -> closingParenthesis());

        // ROOT
        operators[11].addActionListener(e -> inputOperator("√"));

        // NTH ROOT
        operators[12].addActionListener(e -> inputOperator("ⁿ√"));

        // DIVIDE
        operators[13].addActionListener(e -> inputOperator("/"));

        // LOGARITHM
        operators[14].addActionListener(e -> inputOperator("log"));

        // MULLTIPLY
        operators[18].addActionListener(e -> inputOperator("*"));

        // LOG x
        operators[19].addActionListener(e -> inputOperator("logx"));

        // SUBTRACT
        operators[23].addActionListener(e -> inputOperator("-"));

        // E CONSTANT
        operators[24].addActionListener(e -> inputOperator(Double.toString(Math.E)));

        // ADDITION
        operators[28].addActionListener(e -> inputOperator("+"));

        // LN
        operators[29].addActionListener(e -> inputOperator("ln"));

        // NEGATE
        operators[30].addActionListener(e -> negate());

        // DECIMAL
        operators[32].addActionListener(e -> inputString("."));

        // SHOW RESULT
        operators[33].addActionListener(e -> result());

        for (JButton button : operators){
            if (Character.isDigit(button.getText().charAt(0)))
                System.out.println("test");
                button.addActionListener(e -> inputString(button.getText()));
        }

    }


}
