class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        char[] chars = rsp.toCharArray();
        for (char ch : chars) {
            sb.append(getWinner(ch));
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    public char getWinner(char ch) {
        switch(ch) {
            case '2':
                return '0';
            case '0':
                return '5';
            case '5':
                return '2';
        }
        return ' ';
    }
}