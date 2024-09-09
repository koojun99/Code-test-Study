class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        for (int i=1; i <= 100; i++) {
            int pizzas = i*slice;
            if (pizzas/n >= 1 ) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}