import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 2;  // 기본값은 삼각형을 만들 수 없는 상태
        int maxSide = Arrays.stream(sides).max().getAsInt();  // 최대값 찾기

        // 세 변 중 가장 긴 변을 제외한 나머지 두 변의 합과 비교
        int sumOfOtherSides = Arrays.stream(sides).sum() - maxSide;
        
        // 삼각형 조건: 가장 긴 변이 나머지 두 변의 합보다 작아야 함
        if (maxSide < sumOfOtherSides) {
            answer = 1;  // 삼각형을 만들 수 있는 경우
        }

        return answer;
    }
}