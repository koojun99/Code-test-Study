import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> people = new HashMap<>();
        for (String person : participant) {
          people.put(person, people.getOrDefault(person, 0) + 1);  
        }
        
        for (String player : completion) {
            int current = people.get(player);
            if (current > 1) {
                people.put(player, current - 1);
            } else {
                people.remove(player);
            }
        }
        
        Set<String> remainingKeys = people.keySet();
        for (String key : remainingKeys) {
            answer = key;
        }
        return answer;
    }
}