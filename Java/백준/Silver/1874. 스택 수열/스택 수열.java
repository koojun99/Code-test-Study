import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] order = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt();
        }

        while (num <= n || !stack.isEmpty()) {
            if (num <= n && (stack.isEmpty() || stack.peek() < order[idx])) {
                stack.push(num++);
                sb.append("+\n");
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}