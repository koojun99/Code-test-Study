class Solution {
    public String solution(String my_string) {
        String answer = "";
        String reversed = new StringBuilder(my_string).reverse().toString();
        answer = reversed;
        return answer;
    }
}