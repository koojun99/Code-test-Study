import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        for (char ch : my_string.toCharArray()) {
            if (!vowels.contains(String.valueOf(ch))) {
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}