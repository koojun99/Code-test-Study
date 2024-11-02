import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    long treeCount = sc.nextLong();
	    long n = sc.nextLong();
        long[] trees = new long[(int) treeCount];

        for (int i = 0; i < treeCount; i++) {
            trees[i] = sc.nextLong();
        }

        // 이진 탐색 초기화
        long left = 0;
        long right = Arrays.stream(trees).max().getAsLong();
        long height = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long currentWoods = 0;

            // 현재 높이(mid)로 자른 나무 길이 계산
            for (long tree : trees) {
                if (tree > mid) {
                    currentWoods += tree - mid;
                }
            }

            // 필요한 나무 양이 충족되면 높이 증가, 부족하면 높이 감소
            if (currentWoods >= n) {
                height = mid; // 가능한 최대 높이 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(height);
    }
}