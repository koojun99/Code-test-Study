class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int min_diff = Math.abs(array[0] - n);
        for(int num : array) {
            int difference = Math.abs(num - n);
            if (difference < min_diff || (difference == min_diff && num < answer)) {
                min_diff = difference;
                answer = num;
            }
        }
        return answer;
    }
}