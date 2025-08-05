import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        compress(sb, grid, n, 0, 0);

        System.out.println(sb.toString());
    }

    private static void compress(StringBuilder sb, char[][] grid, int n, int X, int Y) {
        if (isValid(grid, n, X, Y)) {
            sb.append(grid[X][Y]);
            return;
        } else {
            sb.append('(');
            compress(sb, grid, n/2, X, Y);
            compress(sb, grid, n/2, X, Y + n/2);
            compress(sb, grid, n/2, X + n/2, Y);
            compress(sb, grid, n/2, X + n/2, Y + n/2);
            sb.append(')');
        }
    }

    private static boolean isValid(char[][] grid, int n, int startX, int startY) {
        char start = grid[startX][startY];
        for (int i = startX; i < startX + n; i++) {
            for (int j = startY; j < startY + n; j++) {
                if (grid[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }

}