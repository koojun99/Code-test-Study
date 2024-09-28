class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] factors = quiz[i].split(" ");
            int result = 0;
            if (factors[1].equals("+")) {
                result = Integer.parseInt(factors[0]) + Integer.parseInt(factors[2]);
            }
            else {
                result = Integer.valueOf(factors[0]) - Integer.valueOf(factors[2]);
            }
            if (Integer.parseInt(factors[4]) == result) {
                    answer[i] = "O";
            }
            else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
}