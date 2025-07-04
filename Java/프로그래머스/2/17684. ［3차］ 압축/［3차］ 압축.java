import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();

        // 1. 초기 사전 설정 (A~Z)
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            dictionary.put(String.valueOf(ch), i + 1);
        }

        List<Integer> output = new ArrayList<>();
        int dictIdx = 27; // 다음에 사전에 등록할 번호
        int i = 0;

        // 2. LZW 압축
        while (i < msg.length()) {
            String w = "" + msg.charAt(i);
            int j = i + 1;

            // 사전에 있는 가장 긴 문자열 찾기
            while (j <= msg.length() && dictionary.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            // 출력 리스트에 해당 문자열의 번호 추가
            output.add(dictionary.get(w));

            // 사전에 새로운 문자열 등록 (w + 다음 글자)
            if (j <= msg.length()) {
                String newEntry = msg.substring(i, j);
                dictionary.put(newEntry, dictIdx++);
            }

            // 다음 위치로 이동
            i += w.length();
        }

        // List -> int[] 변환
        int[] answer = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            answer[k] = output.get(k);
        }
        return answer;
    }
}