class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        if (isParallel(dots[0], dots[1], dots[2], dots[3]) ||
                isParallel(dots[0], dots[2], dots[1], dots[3]) ||
                isParallel(dots[0], dots[3], dots[1], dots[2])){
            answer = 1;
        };
        return answer;
    }
    
    public boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int dx1 = dot2[0] - dot1[0];
        int dx2 = dot4[0] - dot3[0];
        int dy1 = dot2[1] - dot1[1];
        int dy2 = dot4[1] - dot3[1];
        
        return dx1*dy2 == dx2*dy1;
    }
}