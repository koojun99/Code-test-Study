class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] words = letter.split(" ");
        for (String word : words) {
            for (int i = 0; i < codes.length; i++) {
                if (codes[i].equals(word)) {
                    char ch = (char) (i + 'a');
                    sb.append(ch);
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}