import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] periods = new int[n][3];

        for (int i = 0; i < n; i++) {
            periods[i][0] = sc.nextInt();
            periods[i][1] = sc.nextInt();
            periods[i][2] = sc.nextInt();
        }

        Arrays.sort(periods, (a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });

        // 최소 힙 (우선순위 큐)으로 현재 배정된 강의실의 마감 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] period : periods) {
            // 가장 빨리 끝나는 강의실의 마감 시간이 현재 강의 시작 시간보다 작거나 같으면 재사용
            if (!pq.isEmpty() && pq.peek() <= period[1]) {
                pq.poll();
            }

            // 새로운 강의실 추가 (또는 재사용된 강의실 업데이트)
            pq.offer(period[2]);
        }

        // 남아 있는 강의실 수 = 최소 강의실 수
        System.out.println(pq.size());

    }
}
