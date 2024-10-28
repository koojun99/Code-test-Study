import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();

        SpiderGame spiderGame = new SpiderGame();
        System.out.println(spiderGame.solution(x, y));
    }
}

class SpiderGame {
    public long solution(long x, long y) {
        int initialWinRate = (int) (y * 100 / x); // 초기 승률 계산

        // 승률이 이미 100%라면 승률을 높일 수 없으므로 -1 반환
        if (initialWinRate >= 99) {
            return -1;
        }

        long left = 0;
        long right = 1_000_000_000;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            int newWinRate = (int) ((y + mid) * 100 / (x + mid)); // 새로운 승률 계산

            if (newWinRate > initialWinRate) {
                answer = mid; // 조건을 만족하는 최소 mid를 저장
                right = mid - 1; // 더 작은 범위를 탐색
            } else {
                left = mid + 1; // 승률이 변하지 않으면 더 큰 범위를 탐색
            }
        }

        return answer;
    }
}
