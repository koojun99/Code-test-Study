class Solution {
    public int solution(int n) {
        int answer = 0;
        int k = 1;
        int result = 1;
        while (result <= n) {
            
            result *= k;
            if (result > n) {
                k -= 1;
                break;
            }
            k++;
        }
        answer = k;
        return answer;
    }
}