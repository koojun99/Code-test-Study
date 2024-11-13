import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 8;

        for (int i = 1; ; i++) {
            if (n - Math.pow(2, i) == 0) {
                count = count + i + 2; // 복사를 i번, daldidan만드는데 2초 소모된다.
                break;
            } else if (n - Math.pow(2, i) < 0) {
                count = count + i + 1; // 복사를 i번, daldidan만드는데 1초 소모된다.
                break;
            }
        }

        System.out.println(count);
    }
}
