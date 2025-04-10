import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int target = 1; // 1부터 시작: 현재까지 만들 수 있는 금액의 최대치 + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) { // 현재 원소가 target보다 크면 target을 만들 수 없다.
                break;
            } else {
                target += nums[i];
            }
        }

        System.out.println(target);
    }

}