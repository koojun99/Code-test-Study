import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = -1;
        // 값과 빈도를 저장할 HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 최빈값을 찾기 위한 변수 초기화
        int maxFrequency = 0;

        // 배열의 각 값에 대해 빈도 계산 및 최빈값 업데이트
        for (int num : array) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);

            // 빈도 비교 후 최빈값 갱신
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                answer = num;
            } else if (maxFrequency == frequency) {
                answer = -1;
            }
        }
        return answer;
    }
}