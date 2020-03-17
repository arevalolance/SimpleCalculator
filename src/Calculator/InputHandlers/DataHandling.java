package Calculator.InputHandlers;

import Calculator.Compute.Operation;
import Calculator.Window;

class DataHandling extends Window implements DataIO {
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
        inputField.setText(input.append(token).toString());
    }

    /**
     * This method is used for inputting a certain operator into the field. It is done by pressing any of the given operators
     * and it automatically puts it in the {@code runningResultField} which is used for the final computations.
     *
     * @param token a given operator
     */
    public void inputOperator(char token) {
        if (input.toString().equalsIgnoreCase("0"))
            input.delete(0, input.toString().length());

        String series = output.append(input.toString()).append(" ").append(token).append(" ").toString();

        input.delete(0, input.toString().length());

        inputField.setText("0");
        runningResultField.setText(series);
    }
}
