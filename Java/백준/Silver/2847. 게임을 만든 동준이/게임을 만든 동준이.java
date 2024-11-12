import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 레벨 개수
        int[] scores = new int[n]; // 각 레벨의 점수
        int decreaseCount = 0; // 감소시킨 횟수

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // 뒤에서부터 앞으로 순회하면서 현재 점수가 다음 점수보다 크면 조정
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] >= scores[i + 1]) {
                decreaseCount += scores[i] - (scores[i + 1] - 1); // 감소할 횟수 누적
                scores[i] = scores[i + 1] - 1; // 다음 점수보다 1 낮게 설정
            }
        }

        System.out.println(decreaseCount);

    }
}



