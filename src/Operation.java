import java.util.*;

class Operation {

    private static Map<String, Operator> ops = new HashMap<>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
        put("^", Operator.POWER);
    }};

    /**
     * <n>This method is used for checking a given operator's precedence.</n>
     *
     * <n>Algorithm:</n>
     * Checks if a given operator is contained a map created containing all of the operators along with its precedence then checks if its
     * precedence is greater than the other given token.
     *
     * @param op  operator
     * @param sub comparing value
     * @return boolean value
     */
    private static boolean isHigherPrecedence(String op, String sub) {
        return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
    }


    //TODO: THINK OF A BETTER WORD FOR "PRECEDENCE"

    /**
     * <n>This a method to convert a given series (infix) to a postfix form that arranges it according to its proper precedence.</n>
     *
     * <n>It is done by implementing the Shunting Yard Algorithm by Edsger W. Dijkstra.</n>
     *
     * <n>Algorithm:</n>
     * <n>1. Starts the loop throughout the whole series.</n>
     *
     * <n>FOR OPERATORS</n>
     * <n>2. Checks if the first token is a operator by finding it in the map created.</n>
     * <n>2.(1) Checks if the stack is not empty and if its in a higher precedence with the last token in the stack.</n>
     * <n>2.(2) While it is not empty and it is a higher precedence, it will append it the output string.</n>
     * <n>2.(3) It will then push the token (operator) to the stack.</n>
     *
     * <n>FOR LEFT PARENTHESIS</n>
     * <n>3. It then checks if the token is a left parenthesis ('(').</n>
     * <n>3.(1) If it is, it pushes it to the stack.</n>
     *
     * <n>FOR RIGHT PARENTHESIS</n>
     * <n>4. It then checks if the token is a right parenthesis (')').</n>
     * <n>4.(1) If it is, it pops every token in the stack and appends it to the output string.</n>
     * <n>4.(2) It then pops the right parenthesis out of the stack.</n>
     *
     * <n>FOR NUMBERS</n>
     * <n>5. After all the given conditions are false, it is understood as a number and it will automatically append it to the
     * output string.</n>
     *
     * <n>6. When the loop is finished, the remaining items in the stack will be appended into the output string.</n>
     * <n>7. It will then return the output string (postfix) of the series arranged into its proper precedence.</n>
     *
     * @param infix to be converted
     * @return postfix form
     */
    static String toPostFix(String infix) {

        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();


        for (String token : infix.split("\\s")) {
            // operator
            if (ops.containsKey(token)) {
                while (!stack.isEmpty() && isHigherPrecedence(token, stack.peek()))
                    output.append(stack.pop()).append(' ');
                stack.push(token);
            }

            // left parenthesis
            else if (token.equals("(")) {
                stack.push(token);
            }

            // right parenthesis
            else if (token.equals(")")) {
                while (!stack.peek().equals("("))
                    output.append(stack.pop()).append(' ');
                stack.pop();
            } else {
                output.append(token).append(' ');
            }
        }

        while (!stack.isEmpty())
            output.append(stack.pop()).append(' ');

        return output.toString();
    }

    /**
     * <n>This method is used for computing the postfix form of a given series.</n>
     *
     * <n>Algorithm:</n>
     * <n>1. Starts the loop for the whole series.</n>
     * <n>2. It then tries to push the given token to the stack if it is a proper number.</n>
     * <n>3. If it is a operator, it would then pop two items from the stack for computing.</n>
     * <n>4. After the loop is finished and computed, it would then return the final output.</n>
     *
     * @param postfix arranged form of the series
     * @return the result of the series
     */
    static Double computePostFix(String postfix) {

        Stack<Double> stack = new Stack<>();

        for (String token : postfix.split("\\s")) {

            try {

                stack.push((Double.parseDouble(token)));

            } catch (Exception e) {

                double a = stack.pop();
                double b = stack.pop();

                stack.push(compute(b, a, token));
            }

        }

        return stack.peek();
    }

    /**
     * This method is used to identify which operator would be used then automatically computes it right away.
     *
     * @param x  token one
     * @param y  token two
     * @param op operator
     * @return result of two given tokens
     */
    private static double compute(double x, double y, String op) {
        double result = 0;

        switch (ops.get(op)) {
            case ADD:
                result = x + y;
                break;
            case SUBTRACT:
                result = x - y;
                break;
            case MULTIPLY:
                result = x * y;
                break;
            case DIVIDE:
                result = x / y;
                break;
            case POWER:
                result = Math.pow(x, y);
                break;
        }

        return result;
    }

}
