import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int reps = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(n, m) / 2;

        for (int i = 0; i < reps; i++) {
            rotateByLayers(grid, layers);
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateByLayers(int[][] grid, int layers) {
        for (int i = 0; i < layers; i++) {
            rotateCounterClockwise(grid, i);
        }
    }

    private static void rotateCounterClockwise(int[][] grid, int layer) {
        int top = layer;
        int bottom = grid.length - 1 - layer;
        int left = layer;
        int right = grid[0].length - 1 - layer;

        if (top >= bottom || left >= right) return;

        int prev = grid[top+1][right];

        for (int i = right; i >= left; i--) {
            int temp = grid[top][i];
            grid[top][i] = prev;
            prev = temp;
        }

        for (int i = top+1; i <= bottom; i++) {
            int temp = grid[i][left];
            grid[i][left] = prev;
            prev = temp;
        }

        for (int i = left+1; i <= right; i++) {
            int temp = grid[bottom][i];
            grid[bottom][i] = prev;
            prev = temp;
        }

        for (int i = bottom-1; i >= top; i--) {
            int temp = grid[i][right];
            grid[i][right] = prev;
            prev = temp;
        }
    }

}