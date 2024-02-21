import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class PostFixEvaluator {

    public static double evaluatePostfix(Map<String, Double> variables) {
        String postfix = "ab+cd+*"; // Assuming a simplified representation for demonstration
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(variables.get(String.valueOf(c)));
            } else {
                double second = stack.pop();
                double first = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        if (second == 0) throw new ArithmeticException("Division by zero.");
                        stack.push(first / second);
                        break;
                    case '^':
                        stack.push(Math.pow(first, second));
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + c);
                }
            }
        }
        return stack.pop();
    }
}
