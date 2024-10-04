class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int maxSide = Math.max(sides[0], sides[1]);
        int minSide = Math.min(sides[0], sides[1]);
        
        for (int i = 1; i < maxSide; i++) {
            if (i + minSide > maxSide) {
                answer += 1;
            }
        }
        
        for (int i = maxSide; i < minSide + maxSide; i++) {
            answer += 1;
        }
        return answer;
    }
}