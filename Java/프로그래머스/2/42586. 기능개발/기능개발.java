import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> answerList = new ArrayList<>();
        int index = 0;
        
        while (index < n) {
            int days = (int)Math.ceil((100 - progresses[index]) / (double)speeds[index]);
            int count = 0;
            while(index < n && Math.ceil((100 - progresses[index]) / (double)speeds[index]) <= days) {
                count++;
                index++;
            }
            answerList.add(count);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}