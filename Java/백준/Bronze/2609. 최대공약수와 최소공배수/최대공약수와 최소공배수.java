import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        System.out.println(gcd(x, y));
        System.out.println(lcm(x, y));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    private static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        return a*b / gcd(a, b);
    }

}