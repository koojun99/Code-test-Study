class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            // 짝수면 x+1이 답
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                // 홀수면 0b...0111 같은 형태이므로, 비트 조작
                long bit = 1;
                while ((x & bit) != 0) {
                    bit <<= 1;
                }
                // 가장 낮은 0을 1로, 그 전의 1을 0으로
                answer[i] = x + bit - (bit >> 1);
            }
        }
        
        return answer;
    }
}