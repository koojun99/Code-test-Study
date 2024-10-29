import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        CrossRiver crossRiver = new CrossRiver();
        
        for (int i = 0; i < T; i++) { // 'count' 대신 'T' 사용
            long n = sc.nextLong(); // 'n'도 long 타입으로 변경
            long result = crossRiver.solution(n);
            System.out.println(result);
        }
    }
}

class CrossRiver {
    public long solution(long n) {
        long left = 1, right = (long) Math.sqrt(2 * n); // 오른쪽 범위 설정
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = (mid * (mid + 1)) / 2; // 1부터 mid까지의 합

            if (sum == n) {
                return mid; // 정확히 n에 도달할 수 있는 경우
            } else if (sum < n) {
                answer = mid; // 가능한 최대 점프 횟수 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
