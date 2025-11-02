import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] liquids = new int[n];

        for (int i = 0; i < n; i++) {
            liquids[i] = sc.nextInt();
        }

        Arrays.sort(liquids); // 정렬 필요!

        int closestSum = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            int target = -liquids[i];
            int idx = lowerBound(liquids, target, i + 1, n - 1);

            // 왼쪽 후보
            if (idx - 1 > i && idx - 1 < n) {
                int sum = liquids[i] + liquids[idx - 1];
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                }
            }

            // 오른쪽 후보
            if (idx > i && idx < n) {
                int sum = liquids[i] + liquids[idx];
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                }
            }
        }

        System.out.println(closestSum);
    }

    private static int lowerBound(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}