class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        for (int i = 1; i < k; i++) {
            answer += 2; 
        }
        return numbers[answer%numbers.length];
    }
}