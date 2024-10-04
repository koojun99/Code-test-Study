class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {
                // 숫자인 경우 StringBuilder에 추가
                number.append(ch);
            } else {
                // 숫자가 아닌 문자가 나오면 지금까지 모은 숫자를 더하고 초기화
                if (number.length() > 0) {
                    answer += Integer.parseInt(number.toString());
                    number.setLength(0);  // 숫자를 초기화
                }
            }
        }

        // 마지막으로 숫자가 남아있는 경우 처리
        if (number.length() > 0) {
            answer += Integer.parseInt(number.toString());
        }
        return answer;
    }
}