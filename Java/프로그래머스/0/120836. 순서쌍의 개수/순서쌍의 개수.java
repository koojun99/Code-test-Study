class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                answer += 1; // i는 n의 약수
                if (i != n / i) {
                    answer += 1; // n / i도 n의 약수
                }
            }
        }
        return answer;
    }
}