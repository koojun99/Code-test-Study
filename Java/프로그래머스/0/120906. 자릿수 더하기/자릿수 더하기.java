class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] nums = String.valueOf(n).split("");
        for (String num : nums) {
            answer += Integer.valueOf(num);
        }
    
        return answer;
    }
}