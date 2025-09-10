import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int left = 0, right = 0, sum = 0;
        while (true) {
            if (sum >= m) {
                if (sum == m) answer++;
                sum -= nums[left++];
            } else {
                if (right == n) break;
                sum += nums[right++];
            }
        }
        System.out.println(answer);
    }
}