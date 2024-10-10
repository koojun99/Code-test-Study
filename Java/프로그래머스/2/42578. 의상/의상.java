import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }
        // 조합 계산: 각 옷의 종류별로 (해당 종류의 옷 개수 + 1)을 곱해준 후, 1을 뺌.
        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        // 아무것도 선택하지 않는 경우를 제외
        return answer - 1;
    }
}