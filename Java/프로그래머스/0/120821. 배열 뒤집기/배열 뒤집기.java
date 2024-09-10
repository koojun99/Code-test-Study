import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        
        // 배열을 뒤집기
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - 1 - i];
        }
        
        return answer;
    }
}