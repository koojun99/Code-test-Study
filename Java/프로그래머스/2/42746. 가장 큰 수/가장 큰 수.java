import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numStrs.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
    
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            sb.append(numStrs[i]);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        String answer = sb.toString();
        return answer;
    }
}