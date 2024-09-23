import java.util.*;

class Solution {
    public int[] solution(String my_string) {

        List<Integer> nums = new ArrayList<>();
        for(char ch : my_string.toCharArray()) {
            if (Character.isDigit(ch)) {
                nums.add(Character.getNumericValue(ch));
            }
        }
        
        Collections.sort(nums);
        
        return nums.stream().mapToInt(i->i).toArray();
    }
}