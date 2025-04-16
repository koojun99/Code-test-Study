import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                sb.append("");
                if (i < words.length - 1) {
                    sb.append(" ");
                }
                continue;
            }
            
            if (Character.isDigit(word.charAt(0))) {
                sb.append(word.toLowerCase());
            } else {
                char first = Character.toUpperCase(word.charAt(0));
                String rest = "";
                if (word.length() > 1) {
                    rest = word.substring(1).toLowerCase();
                }
                sb.append(first).append(rest);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        String answer = sb.toString();
        return answer;
    }
}