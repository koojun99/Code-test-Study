import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static Map<Integer, List<Integer>> likes = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int totalStudents = N * N;
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < totalStudents; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order.add(student);

            List<Integer> likeList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                likeList.add(Integer.parseInt(st.nextToken()));
            }
            likes.put(student, likeList);
        }

        for (int student : order) {
            seatStudent(student);
        }

        System.out.println(calculateSatisfaction());
    }

    static void seatStudent(int student) {
        List<Seat> candidates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) continue;

                int likeCount = 0;
                int emptyCount = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (isValid(nx, ny)) {
                        if (map[nx][ny] == 0) emptyCount++;
                        else if (likes.get(student).contains(map[nx][ny])) likeCount++;
                    }
                }

                candidates.add(new Seat(i, j, likeCount, emptyCount));
            }
        }

        candidates.sort((a, b) -> {
            if (a.like != b.like) return b.like - a.like;
            if (a.empty != b.empty) return b.empty - a.empty;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        Seat chosen = candidates.get(0);
        map[chosen.x][chosen.y] = student;
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static int calculateSatisfaction() {
        int score = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = map[i][j];
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (isValid(nx, ny) && likes.get(student).contains(map[nx][ny])) {
                        count++;
                    }
                }
                if (count == 1) score += 1;
                else if (count == 2) score += 10;
                else if (count == 3) score += 100;
                else if (count == 4) score += 1000;
            }
        }

        return score;
    }

    static class Seat {
        int x, y, like, empty;

        Seat(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }
    }
}