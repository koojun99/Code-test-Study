import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 주사위 개수
        int[][] dice = new int[n][6]; // 주사위 전개도

        // 주사위 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
            }
        }

        // 반대 면 매핑
        int[] opposite = {5, 3, 4, 1, 2, 0};

        int maxSum = 0;

        // 첫 번째 주사위의 모든 면을 바닥으로 설정
        for (int bottom = 0; bottom < 6; bottom++) {
            int sum = 0;
            int currentBottom = bottom;
            int currentTop = opposite[currentBottom];

            for (int i = 0; i < n; i++) {
                // 현재 주사위에서 top과 bottom 제외한 최대값 찾기
                int maxSide = 0;
                for (int j = 0; j < 6; j++) {
                    if (j != currentBottom && j != currentTop) {
                        maxSide = Math.max(maxSide, dice[i][j]);
                    }
                }
                sum += maxSide;

                // 다음 주사위의 bottom/top 설정
                if (i < n - 1) {
                    int nextBottomValue = dice[i][currentTop];
                    for (int j = 0; j < 6; j++) {
                        if (dice[i + 1][j] == nextBottomValue) {
                            currentBottom = j;
                            currentTop = opposite[currentBottom];
                            break;
                        }
                    }
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}

