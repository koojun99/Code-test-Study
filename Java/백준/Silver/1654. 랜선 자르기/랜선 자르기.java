import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long n = sc.nextLong();

        long high = 0;
        long low = 1;

        long answer = 0;

        long[] nums = new long[k];

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            high = Math.max(high, num);
        }



        while(low <= high) {
            long mid = (high + low) / 2;
            long count = 0;
            // 각 랜선에서 mid 길이로 몇 개를 만들 수 있는지 합산
            for (int i = 0; i < k; i++) {
                count += nums[i] / mid;
            }

            if (count >= n) {
                // mid 길이로 충분한 랜선을 만들 수 있으므로, 더 긴 길이도 가능한지 탐색
                answer = mid;
                low = mid + 1;
            } else {
                // mid 길이로는 N개를 만들 수 없으므로, 길이를 줄임
                high = mid - 1;
            }
        }

        System.out.println(answer);

    }
}