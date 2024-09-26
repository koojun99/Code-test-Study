import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String charAsString = String.valueOf(sb.charAt(i));
            countMap.put(charAsString, countMap.getOrDefault(charAsString, 0) + 1);
        }
        
        // keySet을 List로 변환 후 알파벳 순으로 정렬
        Set<String> keySet = countMap.keySet();
        List<String> sortedKeys = new ArrayList<>(keySet);
        Collections.sort(sortedKeys);
        
        StringBuilder result = new StringBuilder();
        for (String key : sortedKeys) {
            if (countMap.get(key) == 1) {
                result.append(key);
            }
        }
        
        String answer = result.toString();
        return answer;
    }
}