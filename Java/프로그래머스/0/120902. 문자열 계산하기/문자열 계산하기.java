class Solution {
    public int solution(String my_string) {
        
        String[] chars = my_string.split(" ");
        int result = Integer.valueOf(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equals("+")) {
                result += Integer.valueOf(chars[i+1]);
            } else if (chars[i].equals("-")) {
                result -= Integer.valueOf(chars[i+1]);
            }
        }
        return result;
    }
}