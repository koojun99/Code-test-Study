import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = total / num;
        int sum = 0;
        
        while(true) {
            sum = 0;  // sum 초기화
            for (int i = 0; i < num; i++) {
                sum += start + i;  // num개의 연속된 수의 합 계산
            }
            
            // 합이 total과 같으면 종료
            if (sum == total) {
                for (int i = 0; i < num; i++) {
                    answer[i] = start + i;  // answer에 값 채우기
                }
                break;
            }
            
            // 합이 부족하면 start를 증가시키고, 합이 넘치면 start를 감소시킴
            if (sum < total) {
                start += 1;
            } else if (sum > total) {
                start -= 1;
            }
        }
        
        return answer;
    }
}