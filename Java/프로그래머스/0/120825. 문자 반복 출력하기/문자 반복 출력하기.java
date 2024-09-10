class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (char ch : my_string.toCharArray()) {
            for(int i=0; i < n; i++) {
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}