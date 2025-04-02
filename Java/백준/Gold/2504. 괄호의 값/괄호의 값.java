
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char ch : input) {
            if (ch == '(') {
                stack.push(-2);
            } else if (ch == '[') {
                stack.push(-3);
            }

            if (ch == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    sum += stack.pop();
                }

                if (stack.isEmpty() || stack.peek() != -2) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                stack.push(sum == 0 ? 2 : sum*2);
            }

            if (ch == ']') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    sum += stack.pop();
                }

                if (stack.isEmpty() || stack.peek() != -3) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                stack.push(sum == 0 ? 3 : sum*3);
            }
        }

        int answer = 0;
        for (int num : stack) {
            if (num < 0) {
                System.out.println(0);
                return;
            }

            answer += num;
        }

        System.out.println(answer);
    }
}