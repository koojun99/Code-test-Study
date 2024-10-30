import java.util.*;

class Solution {
    public long solution(int n, int[] times) {

        long min_time = 1;
        long max_time = (long) Arrays.stream(times).max().getAsInt() * n;
        
        while (min_time <= max_time) {
            long people = 0;
            long mid_time = (min_time + max_time) / 2;
            for (int i = 0; i < times.length; i++) {
                people += mid_time / times[i];
            }
            
            if (people >= n) {
                max_time = mid_time - 1;
            } else {
                min_time = mid_time + 1;
            }
        }
        return min_time;
    }
}