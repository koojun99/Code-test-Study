import java.util.*;

public class Main {
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt(); // 열
        int x = sc.nextInt(); // 행
        int z = sc.nextInt(); // 층

        int[][][] farm = new int[z][x][y];
        Queue<Point> queue = new LinkedList<>();
        int totalDays = 0;

        // 입력 처리 및 초기 익은 토마토 위치를 Queue에 추가
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    farm[i][j][k] = sc.nextInt();
                    if (farm[i][j][k] == 1) {
                        queue.offer(new Point(j, k, i));
                    }
                }
            }
        }

        // BFS 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNewRipening = false;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                for (int j = 0; j < 6; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    int nz = current.z + dz[j];

                    if (isValid(nx, ny, nz, farm) && farm[nz][nx][ny] == 0) {
                        farm[nz][nx][ny] = 1;
                        queue.offer(new Point(nx, ny, nz));
                        hasNewRipening = true;
                    }
                }
            }

            if (hasNewRipening) {
                totalDays++;
            }
        }

        // 익지 않은 토마토가 남아있는지 확인
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (farm[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(totalDays);
    }

    private static boolean isValid(int x, int y, int z, int[][][] farm) {
        return x >= 0 && y >= 0 && z >= 0 && x < farm[0].length && y < farm[0][0].length && z < farm.length;
    }

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
