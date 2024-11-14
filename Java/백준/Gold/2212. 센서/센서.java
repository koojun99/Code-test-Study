import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int range = 0;
        int[] sensors = new int[n];

        if (k >= n) {
            System.out.println(0);
            return; // 관제탑 개수가 센서보다 많으면 커버 범위 0
        }

        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }
        Arrays.sort(sensors);

        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distances); // 거리 배열 정렬

        // 상위 k-1개의 큰 거리를 제외한 나머지 합산
        for (int i = 0; i < n - k; i++) {
            range += distances[i];
        }

        System.out.println(range);
    }
}
