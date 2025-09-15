import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] students = new int[2][7];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int grade = sc.nextInt();
            students[s][grade]++;
        }

        int rooms = 0;
        for (int s = 0; s <= 1; s++) {
            for (int y = 1; y <= 6; y++) {
                int count = students[s][y];
                if (count > 0) {
                    rooms += (count + k - 1) / k;
                }
            }
        }
        System.out.println(rooms);
    }
}