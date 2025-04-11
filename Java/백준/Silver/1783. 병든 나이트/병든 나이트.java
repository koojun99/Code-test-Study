import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 체스판 세로 길이
        int M = sc.nextInt(); // 체스판 가로 길이
        
        int answer = 0;
        
        // 조건에 따른 분기 처리
        if (N == 1) {
            // 세로 길이가 1이면, 시작 칸 외에는 이동 불가
            answer = 1;
        } else if (N == 2) {
            // 세로 길이가 2이면, (M+1)/2 칸까지 이동 가능하지만 최대 4칸을 넘지 못함
            answer = Math.min(4, (M + 1) / 2);
        } else { // N >= 3
            if (M < 7) {
                // 가로 길이가 7 미만이면, 최대 방문 가능 칸은 M 또는 4 중 작은 값임
                answer = Math.min(4, M);
            } else {
                // N >= 3이고 M >= 7인 경우, 반드시 4가지 이동 방법을 모두 사용해야 하므로
                // 결과는 M - 2가 된다.
                answer = M - 2;
            }
        }
        
        System.out.println(answer);
    }
}
