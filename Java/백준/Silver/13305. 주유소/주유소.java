import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
        int curr = 0;
        int[] dists = new int[n-1];
        int[] prices = new int[n];

        for (int i = 0; i < n-1; i++) {
            dists[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        answer += prices[curr]*dists[curr];

        for (int i = 1; i < n-1; i++) {
            if (prices[curr]*dists[i] < prices[i]*dists[i]) {
                answer += prices[curr]*dists[i];
            } else {
                answer += prices[i] * dists[i];
                curr = i;
            }

        }

        System.out.println(answer);
    }

}