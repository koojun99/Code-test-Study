import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
               return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
        }
        );

        int current = 0;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= current) {
                answer++;
                current = meetings[i][1];
            }
        }

        System.out.println(answer);
    }

}