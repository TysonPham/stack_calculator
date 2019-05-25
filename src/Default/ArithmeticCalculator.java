/**
 * Author: Tyson Pham
 * Class: COMP 352 Data Structure and Algorithm
 */

package Default;

public class ArithmeticCalculator {

    private static GenStack<Integer> valStk = new GenStack<>(); //stack for values
    private static GenStack<String> opStk = new GenStack<>(); //stack for operands
    private String eq;

    /**
     * Calculates Arithmetic Operations
     *
     * @return the total of the equation
     */
    int evalExp(String str) {

        eq = str.concat("$").trim();

        while (!eq.equals("")) {
            if (eq.charAt(0) == ' ')  {
                shrinkEq();
            } else if (Character.isDigit(eq.charAt(0)))  {
                valStk.push(getNum());
            } else if (isOp())  {
                repeatOps(getOp());
            }
        }

        return valStk.pop(); /* Return final result! */
    }

    /**
     * Execute all operators until complete
     */
    void repeatOps(String nextOp) {

        /* Unary Operation */
        if (nextOp.equals("(")) {
            opStk.push("(");
            return;
        } else if (nextOp.equals(")")) {
            while (!opStk.top().equals("(")) {
                valStk.push(doOp());
            }
            opStk.pop();
            return;
        } else if (nextOp.equals("-") && Character.isDigit(eq.charAt(0))) {
            valStk.push(-1 * getNum());
            return;
        }

        /* Look at previous operation */
        String previous = opStk.top();
        if (previous == null || previous.equals("(")) {
            if (nextOp.equals("$"))
                return;
            opStk.push(nextOp);
            return;
        }

        /* Loop until the previous doesn't have a higher precedence */
        while (valStk.size() > 1 && prec(previous) <= prec(nextOp)) {
            if (previous == null || previous.equals("(")) {
                if (nextOp.equals("$"))
                    return;
                opStk.push(nextOp);
                return;
            }
            valStk.push(doOp());
            previous = opStk.top();
        }
        if (nextOp.equals("$"))
            return;
        opStk.push(nextOp);
    }

    static int doOp() {


        String op = opStk.pop();

        int x = valStk.pop(), y = valStk.pop();

        /* Binary Operation */
        switch (op) {
            case "+":
                return y + x;
            case "-":
                return y - x;
            case "*":
                return y * x;
            case "/":
                if (x == 0) {
                    System.out.println("Cannot do division by zero. Returning 0");
                    return 0;
                }
                return y / x;
            case "^":
                return (int) Math.pow(y, x);
            case ">":
                if (y > x)
                    return 1;
                else
                    return -1;
            case ">=":
                if (y >= x)
                    return 1;
                else
                    return -1;
            case "<":
                if (y < x)
                    return 1;
                else
                    return -1;
            case "<=":
                if (y <= x)
                    return 1;
                else
                    return -1;
            case "==":
                if (y == x)
                    return 1;
                else
                    return -1;
            case "!=":
                if (y != x)
                    return 1;
                else
                    return -1;
        }
        return 0;
    }

    /**
     * Return a value of the precedence of an operation Lowest is the higher value.
     *
     * @param op an operator
     * @return level of importance
     */
    int prec(String op) {
        switch (op) {
            case "(":
                return 0;
            case ")":
                return 1;

            case "^":
                return 4;
            case "*":
            case "/":
                return 5;
            case "+":
            case "-":
                return 6;
            case ">":
            case ">=":
            case "<=":
            case "<":
                return 7;
            case "==":
            case "!=":
                return 8;
            case "$":
                return 9;
            default:
                return 0;
        }
    }


    /**
     * Return a number that has more then 1 or more digit.
     *
     * @return a composed number
     */
    int getNum() {
        String temp = "";
        while (Character.isDigit(eq.charAt(0))) {
            temp = temp.concat(Character.toString(eq.charAt(0)));
            shrinkEq();
        }
        return Integer.parseInt(temp);
    }

    /**
     * Verify if the first char is an operator!
     *
     * @return boolean response
     */
    boolean isOp() {
        return eq.charAt(0) == '(' /* Open Parenthesis */ || eq.charAt(0) == ')' /* Close Parenthesis */
                || eq.charAt(0) == '!' /* Factorial */ || eq.charAt(0) == '-' /* Negative Sign */
                || eq.charAt(0) == '^' /* Power */ || eq.charAt(0) == '*' /* Multiplication */
                || eq.charAt(0) == '/' /* Division */ || eq.charAt(0) == '+' /* Addition */
                || eq.charAt(0) == '>' /* Larger */ || eq.charAt(0) == '<' /* Less */ || eq.charAt(0) == '='/* Equal */
                || eq.charAt(0) == '$' /* Dollar Sign */;
    }

    /**
     * Return an operator
     *
     * @return a operator
     */
    String getOp() {
        String temp = Character.toString(eq.charAt(0));
        shrinkEq();
        if (!eq.equals("") && (eq.charAt(0)) == 61) {
            temp = temp.concat(Character.toString(eq.charAt(0)));
            shrinkEq();
        }
        return temp;
    }


    /**
     * Reduce the equation by 1 character
     */
    void shrinkEq() {
        eq = eq.substring(1);
    }

}