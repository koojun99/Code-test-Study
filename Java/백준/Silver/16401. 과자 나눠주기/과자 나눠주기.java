import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nephews = sc.nextInt();
        int candies = sc.nextInt();
        int[] sizes = new int[candies];

        for (int i = 0; i < candies; i++) {
            sizes[i] = sc.nextInt();
        }

        Arrays.sort(sizes);
        int low = 1;
        int high = sizes[candies-1];
        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int pieces = getPieces(sizes, mid);
            if (pieces >= nephews) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static int getPieces(int[] sizes, int m) {
        int sum = 0;
        for (int size : sizes) {
            sum += size / m;
        }

        return sum;
    }
}
