class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
            else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
        }
        answer = sb.toString();
        return answer;
    }
}