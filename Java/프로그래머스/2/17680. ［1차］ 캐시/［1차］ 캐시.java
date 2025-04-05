import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            answer = cities.length*5;
            return answer;
        }
        List<String> cache = new ArrayList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (!cache.contains(city)){
                if (cache.size() < cacheSize) {
                    cache.add(city);
                    answer += 5;
                } else {
                    cache.remove(0);
                    cache.add(city);
                    answer += 5;
                }
            } else {
                cache.remove(city);
                cache.add(city);
                answer ++;
            }
            
        }
        return answer;
    }
}