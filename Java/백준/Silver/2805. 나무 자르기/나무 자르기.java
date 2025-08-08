import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] trees = new int[n];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int low = 0;
        int high = maxHeight;
        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int i = 0; i < n; i++) {
                total += Math.max(0, trees[i] - mid);
            }

            if (total >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);

    }
}