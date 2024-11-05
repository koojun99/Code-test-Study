import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt(); // 체스판 한 변의 길이
            int x = sc.nextInt(); // x 좌표
            int y = sc.nextInt(); // y 좌표

            int targetX = sc.nextInt(); // 목표 x 좌표
            int targetY = sc.nextInt(); // 목표 y 좌표

            int result = moveKnight(n, x, y, targetX, targetY);
            System.out.println(result);
        }
        sc.close();
    }

    private static int moveKnight(int n, int x, int y, int targetX, int targetY) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // 시작 위치와 목표 위치가 동일하면 이동할 필요 없음
        if (x == targetX && y == targetY) {
            return 0;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++; // 현재 레벨에서 모든 이동을 처리한 후에 count 증가

            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int currentX = point.x;
                int currentY = point.y;

                for (int j = 0; j < 8; j++) {
                    int nx = currentX + dx[j];
                    int ny = currentY + dy[j];

                    if (nx == targetX && ny == targetY) {
                        return count; // 목표 지점에 도달하면 이동 횟수 반환
                    }

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
        static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
