import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            Map<String, Double> variables = new HashMap<>();
            System.out.println("Please enter values for the identifiers a, b, c, and d.");
            variables.put("a", promptForValue("a", scanner));
            variables.put("b", promptForValue("b", scanner));
            variables.put("c", promptForValue("c", scanner));
            variables.put("d", promptForValue("d", scanner));

            // Direct computation after substitution for infix
            double infixResult = (variables.get("a") + variables.get("b")) * (variables.get("c") + variables.get("d"));
            System.out.println("Value of infix expression (a+b)*(c+d) with a = " + variables.get("a") +
                    ", b = " + variables.get("b") + ", c = " + variables.get("c") + ", d = " + variables.get("d") +
                    " is " + infixResult);

//            double InfixResult = InfixEvaluator.evaluateInfix(variables);
//            System.out.println("Value of infix expression ab+cd+* with a = " + variables.get("a") +
//                    ", b = " + variables.get("b") + ", c = " + variables.get("c") + ", d = " + variables.get("d") +
//                    " is " + postfixResult);
            // Stack-based evaluation for postfix with additional operations
            double postfixResult = PostFixEvaluator.evaluatePostfix(variables);
            System.out.println("Value of postfix expression ab+cd+* with a = " + variables.get("a") +
                    ", b = " + variables.get("b") + ", c = " + variables.get("c") + ", d = " + variables.get("d") +
                    " is " + postfixResult);

            System.out.println("Do you want to compute another expression? (yes/no)");
            userInput = scanner.next().trim().toLowerCase();
        } while (userInput.equals("yes"));

        scanner.close();
        System.out.println("Program ended.");
    }

    private static double promptForValue(String identifier, Scanner scanner) {
        System.out.print("Enter value for " + identifier + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter value for " + identifier + ": ");
        }
        return scanner.nextDouble();
    }
}