import java.util.Stack;

public class InfixEvaluator {
    // Method to evaluate the infix expression
    public static int evaluateInfix(String expression) {
        // Stack for numbers: 'valueStack'
        Stack<Integer> valueStack = new Stack<>();

        // Stack for Operators: 'operatorStack'
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the scanned character is a whitespace, skip it
            if (c == ' ')
                continue;

            // If the scanned character is a digit, read the number and push it to valueStack
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--; // since the for loop also increases i
                valueStack.push(num);
            }
            // If the scanned character is '(', push it to operatorStack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If the scanned character is ')', solve the entire bracket
            else if (c == ')') {
                while (operatorStack.peek() != '(')
                    valueStack.push(applyOp(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
                operatorStack.pop();
            }
            // If the scanned character is an operator
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operatorStack.isEmpty() && hasPrecedence(c, operatorStack.peek()))
                    valueStack.push(applyOp(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
                // Push current operator to operatorStack
                operatorStack.push(c);
            }
        }

        // Entire expression has been parsed at this point, apply remaining operators
        while (!operatorStack.isEmpty())
            valueStack.push(applyOp(operatorStack.pop(), valueStack.pop(), valueStack.pop()));

        // Top of 'valueStack' contains result, return it
        return valueStack.pop();
    }

    // Method to apply an operator 'op' on operands 'a' and 'b'
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }


    /*NOTES
    *
Infix Expression Evaluation
The parts of the expression surrounded by opening brace and closing brace must be calculated first.
Next, operator 'of' should be processed.
Next process division and multiplication. ...
Next comes Addition and Subtraction.
    * */
    // Method to return precedence of operators; higher returned value means higher precedence
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // Main method to test the evaluateInfix method
    public static void main(String[] args) {
        String expression = "10 + 2 * 6";
        System.out.println(evaluateInfix(expression));

        expression = "100 * 2 + 12";
        System.out.println(evaluateInfix(expression));

        expression = "100 * ( 2 + 12 )";
        System.out.println(evaluateInfix(expression));

        expression = "100 * ( 2 + 12 ) / 14";
        System.out.println(evaluateInfix(expression));
    }
}

