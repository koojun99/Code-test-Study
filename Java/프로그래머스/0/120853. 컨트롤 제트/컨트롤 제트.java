class Solution {
    public int solution(String s) {
        Integer result = 0;
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("Z")){
                result -= Integer.valueOf(words[i-1]);
                continue;
            }
                result += Integer.valueOf(words[i]);
        }
        int answer = (int) result;
        return answer;
    }
}