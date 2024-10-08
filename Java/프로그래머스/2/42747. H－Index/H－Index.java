import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = 0;
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i;  // 남은 논문의 수
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        return hIndex;
    }
}