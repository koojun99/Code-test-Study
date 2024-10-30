import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] bigger = new int[sizes.length];
        int[] smaller = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            bigger[i] = Math.max(sizes[i][0], sizes[i][1]);
            smaller[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int height = Arrays.stream(bigger).max().getAsInt();
        int width = Arrays.stream(smaller).max().getAsInt();
        
        answer = height * width;
        return answer;
    }
}