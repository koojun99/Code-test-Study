import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] nums = number.split("0+");
        
        for (String numstr : nums) {
            if (numstr.isEmpty()) {
                continue;
            }
            long num = Long.parseLong(numstr);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i*i <= num; i++) {
            if (num%i ==0) {
                return false;
            }
        }
        
        return true;
    }
}