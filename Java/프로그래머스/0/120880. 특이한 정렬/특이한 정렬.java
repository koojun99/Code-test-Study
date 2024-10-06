import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        Integer[] numlistObj = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(numlistObj, (a, b) -> {
            int diffA = Math.abs(a - n);
            int diffB = Math.abs(b - n);
            
            if (diffA == diffB) {
                return b - a;
            }
            
            return diffA - diffB;
            }
        );
        return Arrays.stream(numlistObj).mapToInt(Integer::intValue).toArray();
    }
}