import java.util.Scanner;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수
        int T = sc.nextInt();
        sc.nextLine(); // 개행문자 소비

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 카드의 개수
            sc.nextLine(); // 개행문자 소비
            String[] cards = sc.nextLine().split(" "); // 카드 입력

            // Deque 초기화 및 첫 번째 카드 삽입
            Deque<String> deque = new LinkedList<>();
            deque.add(cards[0]); // 첫 번째 카드는 무조건 삽입

            // 나머지 카드 처리
            for (int i = 1; i < N; i++) {
                if (cards[i].compareTo(deque.peekFirst()) <= 0) {
                    // 사전순으로 더 빠르면 왼쪽에 추가
                    deque.addFirst(cards[i]);
                } else {
                    // 그렇지 않으면 오른쪽에 추가
                    deque.addLast(cards[i]);
                }
            }

            // 결과 출력
            StringBuilder result = new StringBuilder();
            for (String card : deque) {
                result.append(card);
            }
            System.out.println(result.toString());
        }
    }
}



