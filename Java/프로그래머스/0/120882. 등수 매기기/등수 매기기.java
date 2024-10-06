import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        double[][] average = new double[score.length][2];
        
        for (int i = 0; i < average.length; i++) {
            double avgScore =  (score[i][0] + score[i][1]) / 2.0;
            average[i][0] = i;  // 학생 번호 (1-based index)
            average[i][1] = avgScore;  // 평균 점수
        }
        
        // 평균 점수를 기준으로 내림차순 정렬
        Arrays.sort(average, (a, b) -> Double.compare(b[1], a[1]));
        
        int[] answer = new int[score.length];
        
        int rank = 1;  // 현재 등수
        answer[(int) average[0][0]] = rank;  // 1등부터 시작
        int sameRankCount = 1;  // 동일한 등수를 받은 학생 수

        for (int i = 1; i < answer.length; i++) {
            // 이전 학생과 점수가 같으면 동일한 등수, 다르면 새로운 등수
            if (average[i][1] == average[i - 1][1]) {
                answer[(int) average[i][0]] = rank;  // 같은 등수 부여
                sameRankCount++;
            } else {
                rank += sameRankCount;  // 다른 점수일 경우 등수를 갱신
                answer[(int) average[i][0]] = rank;
                sameRankCount = 1;
            }
        }
        return answer;
    }
}