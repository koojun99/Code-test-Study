import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시작 시간 기준 정렬
        Arrays.sort(book_time, (a, b) -> Integer.compare(toMinutes(a[0]), toMinutes(b[0])));

        // 2. 종료 시간을 담을 우선순위 큐 (오름차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]) + 10; // 청소 시간 10분 포함

            // 가장 빨리 비는 방이 다음 예약보다 일찍 비면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 기존 방 재사용
            }

            pq.offer(end); // 새로 사용한(또는 재사용한) 방의 종료 시간 갱신
        }

        return pq.size(); // 동시에 사용되는 방의 최대 수 == 최소 객실 수
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour*60 + minute;
    }
}