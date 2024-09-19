class Solution {
    public String solution(int age) {
        StringBuilder result = new StringBuilder();
        String numStr = String.valueOf(age);  // 숫자를 문자열로 변환

        // 문자열의 각 자릿수 순회
        for (char digit : numStr.toCharArray()) {
            char letter = (char) ('a' + (digit - '0'));  
            result.append(letter);  // 알파벳을 뒤에 추가
        }

        return result.toString();
    }
}