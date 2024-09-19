import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        // 기본형 배열을 객체 배열로 변환 (int[] -> Integer[])
        Integer[] sorted = Arrays.stream(emergency)
                                 .boxed()
                                 .toArray(Integer[]::new);
        
        // 내림차순 정렬
        Arrays.sort(sorted, Collections.reverseOrder());
        
        // 결과를 저장할 배열 생성
        int[] answer = new int[emergency.length];
        
        // 원본 배열의 값에 대한 순위를 저장
        for (int i = 0; i < emergency.length; i++) {
            // 원본 배열의 값을 정렬된 배열에서 찾고, 순위로 변환
            answer[i] = Arrays.asList(sorted).indexOf(emergency[i]) + 1;
        }
        return answer;
    }
}