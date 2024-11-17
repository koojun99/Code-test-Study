class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        int size = brown + yellow;
        
        
        for(int i = 1; i <= size / 2; i++) {
            int x = i;
            int y = size / x;
            if ((x-2)*(y-2) == yellow) {
                answer[0] = Math.max(x, y);
                answer[1] = Math.min(x, y);
            }
        }
        
        return answer;
    }
}