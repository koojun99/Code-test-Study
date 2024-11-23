import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rocks = sc.nextInt(); // 주사위 개수
        String[] orders = {"SK", "CY"}; // CY: CY의 차례, SK: SK의 차례
        int order = 0; // 0: CY, 1: SK

        while (rocks > 0) {
            if (rocks >= 3) {
                rocks -= 3;
            } else {
                rocks -= 1;
            }
            order = (order + 1) % 2;
        }

        // 마지막으로 돌을 가져간 사람 출력
        System.out.println(orders[(order + 1) % 2]);
    }
}