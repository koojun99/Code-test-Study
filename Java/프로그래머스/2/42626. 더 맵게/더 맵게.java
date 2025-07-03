import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int degree : scoville) {
            pq.add(degree);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            int mixed = a + b*2;
            pq.add(mixed);
            answer++;
        }
        
        
        return pq.peek() < K ? -1 : answer;
    }
}