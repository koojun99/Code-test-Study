import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] demands = new int[n];

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            demands[i] = sc.nextInt();
            right = Math.max(right, demands[i]); // 최댓값 기준
        }

        int budget = sc.nextInt();
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int total = getTotal(demands, mid);

            if (total <= budget) {
                answer = mid;        // 상한액 후보 저장
                left = mid + 1;      // 더 올릴 수 있는지 탐색
            } else {
                right = mid - 1;     // 예산 초과, 상한액 줄이기
            }
        }

        System.out.println(answer);
    }

    private static int getTotal(int[] demands, int cap) {
        int sum = 0;
        for (int demand : demands) {
            sum += Math.min(demand, cap);
        }
        return sum;
    }
}