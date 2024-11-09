import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // 목표 고양이 수
        System.out.println(minActions(n));
    }

    private static long minActions(long n) {
        long actions = 0;
        while (n > 3) {
            actions++;
            if (n % 2 != 0) {
                n = n / 2 + 1; // 짝수일 경우 나누기 2
            } else {
                n /= 2; // 홀수일 경우 1을 빼서 짝수로 만듦
            }
        }
        return actions+n;
    }
}


