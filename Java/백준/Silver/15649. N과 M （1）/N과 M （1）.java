import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] answer = new int[m];
        boolean[] used = new boolean[n+1];

        dfs(n, m, 0, answer, used);
    }

    private static void dfs(int n, int m, int digit, int[] answer, boolean[] used) {
        if (digit == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                answer[digit] = i;
                dfs(n, m, digit+1, answer, used);
                used[i] = false;
            }
        }
    }
}