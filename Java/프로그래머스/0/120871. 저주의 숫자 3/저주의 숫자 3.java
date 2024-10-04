class Solution {
    public int solution(int n) {
        int num = 1;
        int order = 1;
        while (order < n) {
            num += 1;
            if (String.valueOf(num).contains("3") || num % 3 == 0){
                continue;
            }
            order += 1;
        }
        return num;
    }
}