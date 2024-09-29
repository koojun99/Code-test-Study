class Solution {
    public int solution(int n) {
        int answer = 2;
        double sqrt = Math.sqrt(n);
        if (sqrt == Math.floor(sqrt)) {
            answer = 1;
        }
        return answer;
    }
}