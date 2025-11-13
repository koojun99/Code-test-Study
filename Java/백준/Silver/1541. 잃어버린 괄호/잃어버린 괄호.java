import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        String[] parts = expression.split("-"); // - 기준으로 나누기

        int result = sum(parts[0]); // 첫 항은 무조건 더함

        for (int i = 1; i < parts.length; i++) {
            result -= sum(parts[i]); // 이후 항은 모두 괄호로 묶어 빼줌
        }

        System.out.println(result);
    }

    private static int sum(String expr) {
        String[] tokens = expr.split("\\+");
        int total = 0;
        for (String token : tokens) {
            total += Integer.parseInt(token);
        }
        return total;
    }
}