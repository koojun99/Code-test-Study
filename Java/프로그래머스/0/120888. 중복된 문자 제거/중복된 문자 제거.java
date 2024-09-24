import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<String> uniqueWords = new HashSet<>();  // 중복 제거를 위한 Set 사용
        
        // 공백을 기준으로 단어 분리
        String[] words = my_string.split("");
        
        for (String word : words) {
            // 중복되지 않은 단어만 추가
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                sb.append(word);
            }
        }
        
        // 마지막 공백 제거 후 문자열 반환
        String answer = sb.toString();
        return answer;
    }
}