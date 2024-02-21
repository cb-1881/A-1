import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixEvaluator {

    // Evaluates the value of an infix expression with variables
    public static double evaluateInfix(String expression, Map<String, Double> variables) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Skip whitespace
            if (c == ' ') continue;

            // If char is a digit or variable, parse and push to values stack
            if (Character.isDigit(c) || Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || Character.isLetter(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;

                // Push variable value or number directly
                double value = Character.isLetter(sb.charAt(0)) ? variables.get(sb.toString()) : Double.parseDouble(sb.toString());
                values.push(value);
            }
            // Opening bracket, push to ops
            else if (c == '(') {
                ops.push(c);
            }
            // Closing bracket, solve entire bracket
            else if (c == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            // Operator
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // While top of ops has same or greater precedence to current token, which is an operator. Apply operator on top of ops to top two elements in values stack.
                while (!ops.empty() && hasPrecedence(c, ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to ops.
                ops.push(c);
            }
        }

        // Entire expression has been parsed at this point, apply remaining ops to values.
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it.
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/' || op1 == '^') && (op2 == '+' || op2 == '-'))
            return true;
        if (op1 == '^' && (op2 == '*' || op2 == '/' || op2 == '^'))
            return false; // '^' is right associative
        return !(op1 == '+' || op1 == '-') || (op2 != '+' && op2 != '-');
    }

    // A utility method to apply an operation 'op' on operands 'a' and 'b'.
    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unsupported operator " + op);
        }
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)";
        Map<String, Double> variables = new HashMap<>();
        variables.put("a", 3.0);
        variables.put("b", 5.0);
        variables.put("c", 2.0);
        variables.put("d", 3.0);
        variables.put("e", 6.0);
        variables.put("f", 1.5);
        variables.put("g", 4.0);
        variables.put("h", 5.0);
        variables.put("i", 100.0);

        System.out.println(evaluateInfix(expression, variables));
    }
}
