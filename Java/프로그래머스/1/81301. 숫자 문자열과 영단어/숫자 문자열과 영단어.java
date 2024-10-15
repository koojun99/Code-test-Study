class Solution {
    public int solution(String s) {
        String[] englishNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // 리스트를 돌면서 s 속에 특정 문자가 있다면 replace
        for (int i = 0; i < englishNumbers.length; i++) {
            s = s.replace(englishNumbers[i], Integer.toString(i));
        }

        // s를 int로 변환하여 리턴
        return Integer.parseInt(s);
    }
}