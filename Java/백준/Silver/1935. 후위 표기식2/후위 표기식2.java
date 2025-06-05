import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String expression = sc.nextLine();
        double[] values = new double[26];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(values[ch - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = 0.0;

                switch (ch) {
                    case '+': result = a+b; break;
                    case '-': result = a-b; break;
                    case '*': result = a*b; break;
                    case '/': result = a/b; break;
                }

                stack.push(result);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}