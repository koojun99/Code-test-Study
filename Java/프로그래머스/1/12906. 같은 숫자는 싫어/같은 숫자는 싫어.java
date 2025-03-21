import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> numList = new ArrayList<>();
        numList.add(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] != arr[i-1]) {
                numList.add(arr[i]);
            }
        }
        int[] answer = new int[numList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numList.get(i);
        }
        
        return answer;
    }
}