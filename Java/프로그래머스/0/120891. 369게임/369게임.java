class Solution {
    public int solution(int order) {
        int answer = 0;
        char[] digits = String.valueOf(order).toCharArray();
        for (char digit : digits) {
            if (digit == '3' || digit == '6' || digit == '9') {
                answer += 1;
            }
        }
        return answer;
    }
}