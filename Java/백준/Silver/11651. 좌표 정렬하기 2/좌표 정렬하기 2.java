import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] coordinates = new int[n][2];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates[i] = new int[]{x, y};
        }

        Arrays.sort(coordinates, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
        });

        for (int[] coordinate : coordinates) {
            System.out.println(coordinate[0] + " " + coordinate[1]);
        }
    }

}