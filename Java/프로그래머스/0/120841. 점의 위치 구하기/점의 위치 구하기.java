class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0];
        int y = dot[1];
        if (x > 0) {
            if (x*y > 0) {
                answer = 1;
            } else {
                answer = 4;
            }
        } else if (x*y > 0) {
            answer = 3;
        } else {
            answer = 2;
        }
        return answer;
    }
}