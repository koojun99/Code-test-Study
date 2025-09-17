import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] serials = new String[n];

        for (int i = 0; i < n; i++) {
            serials[i] = sc.next();
        }

        Arrays.sort(serials, Comparator
                .comparingInt(String::length)
                .thenComparingInt(Main::digitSum)
                .thenComparing(Comparator.naturalOrder()));
        for (String s : serials) {
            System.out.println(s);
        }
    }

    private static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}