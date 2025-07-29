import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            // 가능한 모든 비율 케이스를 확인
            double[] ratios = {1.0, 2.0 / 3, 2.0 / 4, 3.0 / 2, 3.0 / 4, 4.0 / 2, 4.0 / 3};
            for (double ratio : ratios) {
                double key = weight * ratio;
                answer += map.getOrDefault(key, 0);
            }

            // 현재 weight 자체를 키로 추가 (1:1 비율 대비)
            map.put((double)weight, map.getOrDefault((double)weight, 0) + 1);
        }

        return answer;
    }
}