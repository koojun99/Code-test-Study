import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 1;
        Map<Integer, Integer> ponkemons = new HashMap<>();
        
        for (int num : nums) {
            ponkemons.put(num, ponkemons.getOrDefault(num, 0) + 1);
        }
        
        int maxKinds = ponkemons.size();
        int maxChoice = nums.length / 2;
        
        answer = Math.min(maxKinds, maxChoice);
        return answer;
    }
}