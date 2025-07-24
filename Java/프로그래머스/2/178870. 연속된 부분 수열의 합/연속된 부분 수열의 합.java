import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = sequence.length+1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < sequence.length) {
            sum += sequence[right];
            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }
            if (sum == k) {
                int len = right - left + 1;
                if (len < minLength) {
                    minLength = len;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }
        return answer;
    }
}