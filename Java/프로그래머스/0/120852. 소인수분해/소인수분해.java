import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> factors = new HashSet<>();

        // 2로 계속 나누기 (가장 작은 소수)
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // 3 이상의 소수로 나누기
        for (int i = 3; i <= Math.sqrt(n); i += 2) {  // i는 2를 제외한 홀수만
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // 만약 남은 n이 소수인 경우
        if (n > 2) {
            factors.add(n);
        }
// List로 변환 후 정렬
        List<Integer> sortedFactors = new ArrayList<>(factors);
        Collections.sort(sortedFactors);

        // 정렬된 리스트를 int[] 배열로 변환하여 반환
        return sortedFactors.stream().mapToInt(i -> i).toArray();
    }
}