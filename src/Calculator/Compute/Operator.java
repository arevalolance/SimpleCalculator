package Calculator.Compute;

/**
 * {@code Calculator.Compute.Operator} sets all of the proper values for each operator that can be used in a Calculator.Calculator.
 * With this, it will set a value for the proper precedence of every key.
 */
public enum Operator {
    ADD(1),
    SUBTRACT(2),
    MULTIPLY(3),
    DIVIDE(4),
    POWER(5),
    ROOT(5),
    LOG(5),
    TRIG(5);

    /**
     * A value that will contain the precedence of a certain key.
     */
    final int precedence;

    /**
     * A Constructor that contains the proper precedence of the key.
     *
     * @param p precedence
     */
    Operator(int p) {
        precedence = p;
    }
}