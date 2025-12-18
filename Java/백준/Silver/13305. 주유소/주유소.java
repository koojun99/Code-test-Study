import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long answer = 0;
        int[] dists = new int[n - 1];
        int[] prices = new int[n];

        for (int i = 0; i < n - 1; i++) {
            dists[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int minPrice = prices[0];

        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            answer += (long) minPrice * dists[i]; // 반드시 long 변환 필요
        }

        System.out.println(answer);
    }
}