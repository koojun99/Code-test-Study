import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int index = 0; index < commands.length; index++) {
            int[] command = commands[index];
            int start = command[0] - 1;  // 시작 인덱스
            int end = command[1];        // 끝 인덱스
            int k = command[2] - 1;      // k번째 값 (0 기반 인덱스)

            // array 배열에서 [start, end) 범위 추출
            int[] result = Arrays.copyOfRange(array, start, end);

            // 추출한 배열을 정렬
            Arrays.sort(result);

            // k번째 값을 answer 배열에 저장
            answer[index] = result[k];
        }
        return answer;
    }
}