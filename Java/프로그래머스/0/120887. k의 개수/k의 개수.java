class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int a = i; a <= j; a++) {
            int num = a;
            while (num != 0) {
                if (num%10 == k) {
                    answer += 1;
                }
                num /= 10;
            }
        }
        return answer;
    }
}