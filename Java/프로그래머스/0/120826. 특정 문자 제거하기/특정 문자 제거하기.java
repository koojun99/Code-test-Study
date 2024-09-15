class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (ch != letter.charAt(0)) {
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}