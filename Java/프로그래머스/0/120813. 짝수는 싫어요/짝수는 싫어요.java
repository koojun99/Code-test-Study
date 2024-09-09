import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%2 != 0) {
                nums.add(i);
            }
        }
        int[] answer = nums.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}