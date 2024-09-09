class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] nums = {5, 3, 1};
        while(hp != 0) {
            for (int num : nums) {
                if (hp - num >= 0) {
                    hp -= num;
                    answer += 1;
                    break;
                }
            }
        }
        return answer;
    }
}