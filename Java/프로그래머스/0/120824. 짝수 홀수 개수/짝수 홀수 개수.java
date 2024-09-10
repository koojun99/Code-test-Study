class Solution {
    public int[] solution(int[] num_list) {
        int odds = 0;
        int evens = 0;
        for (int num : num_list) {
            if (num%2 == 0) {
                evens += 1;
            }
            else {
                odds += 1;
            }
        }
        int[] answer = {evens, odds};
        
        return answer;
    }
}