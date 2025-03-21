import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        int order = 0; // 배포(출력) 순서
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;
            
            // 큐에 남은 작업 중 현재 작업보다 높은 우선순위가 있는지 확인
            for (int[] job : queue) {
                if (job[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                // 더 높은 우선순위가 있다면 현재 작업을 다시 큐의 뒤로 보냅니다.
                queue.offer(current);
            } else {
                // 그렇지 않으면 현재 작업을 배포(출력)합니다.
                order++;
                if (current[0] == location) {
                    return order;
                }
            }
        }
        return order;
    }
}