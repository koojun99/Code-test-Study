import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int index = 0;
    
    // 다리 위에는 트럭이 bridge_length 칸만큼 있을 수 있다고 가정
    // 매 시간마다 시뮬레이션
    while (index < truck_weights.length || !bridge.isEmpty()) {
        time++;
        
        // 트럭이 다리를 다 건넜다면 제거 (다리 길이만큼 시간이 지난 경우)
        if (!bridge.isEmpty() && time - bridge.peek() == bridge_length) {
            // 트럭이 다리를 건넜으므로 다리 위의 무게 감소
            currentWeight -= truck_weights[index - bridge.size()];
            bridge.poll();
        }
        
        // 다음 트럭을 다리에 올릴 수 있는지 확인
        if (index < truck_weights.length && currentWeight + truck_weights[index] <= weight) {
            currentWeight += truck_weights[index];
            // 현재 시간(time)을 기록하며 트럭을 다리에 올림
            bridge.offer(time);
            index++;
        }
    }
    
    return time;
    }
}