class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if (sum == target) {
                return 1;
            } 
            return 0;
        }
        return dfs(numbers, target, index + 1, sum + numbers[index]) + 
            dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}