import java.util.*;

class Solution {
    public long solution(String numbers) {
        // 영어 단어와 숫자 매핑
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        StringBuilder result = new StringBuilder();
        int i = 0;

        // 문자열을 앞에서부터 하나씩 검사
        while (i < numbers.length()) {
            // 각 숫자 단어의 길이와 영어 단어로 매칭
            for (String word : numberMap.keySet()) {
                if (i + word.length() <= numbers.length() && numbers.substring(i, i + word.length()).equals(word)) {
                    result.append(numberMap.get(word));
                    i += word.length();  // 단어 길이만큼 인덱스 이동
                    break;
                }
            }
        }

        long answer = Long.valueOf(result.toString());
        return answer;
    }
}