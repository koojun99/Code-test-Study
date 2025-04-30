import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals(".")) {
                break;
            }


            boolean isBalanced = isBalancedParen(input);
            if (isBalanced) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isBalancedParen(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            if (ch == ')'  ) {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
