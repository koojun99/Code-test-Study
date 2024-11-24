import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 돌 개수
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // DP 배열 초기화
        int[] dp = new int[n];
        int maxSum = 0;

        // DP 계산: 최대 증가 부분 수열 합 구하기
        for (int i = 0; i < n; i++) {
            dp[i] = numbers[i]; // 자기 자신만 포함하는 경우 최소 길이는 1
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) { // 증가 조건
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]); // 최대 길이 갱신
        }

        // 결과 출력
        System.out.println(maxSum);
    }
}

