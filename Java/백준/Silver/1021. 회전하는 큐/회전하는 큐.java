import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 덱 크기
        int m = sc.nextInt(); // 뽑아야 할 수의 개수

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        int count = 0;

        for (int target : targets) {
            int idx = 0;
            for (int num : deque) {
                if (num == target) break;
                idx++;
            }

            int half = deque.size() / 2;
            if (idx <= half) {
                // 왼쪽으로 회전
                for (int i = 0; i < idx; i++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽으로 회전
                for (int i = 0; i < deque.size() - idx; i++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

            // 제거
            deque.pollFirst();
        }

        System.out.println(count);
    }
}