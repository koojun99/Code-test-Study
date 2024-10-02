import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        int posMax = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int negMax = numbers[0] * numbers[1];
        int answer = Math.max(posMax, negMax);
        return answer;
    }
}