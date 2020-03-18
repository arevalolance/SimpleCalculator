package Calculator.InputHandlers;

/**
 * {@code DataIO} contains instance methods for handling the data inputs.
 */
public interface DataIO {
    /**
     * This method is used for handling the inputted numbers not including the operators by the user.
     *
     * @param token a given data
     */
    void inputString(String token);

    /**
     * This method handles an operator inputted by the user.
     *
     * @param token an operator
     */
    void inputOperator(String token);

    /**
     * This method just simply prompts up the result of the series inputted by the user.
     */
    void showResult();
}
