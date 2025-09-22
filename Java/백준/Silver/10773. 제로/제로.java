import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int answer = 0;
        for (int num : stack) {
            answer += num;
        }

        System.out.println(answer);
    }
}