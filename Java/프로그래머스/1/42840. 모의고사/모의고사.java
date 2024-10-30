import java.util.*;

class Solution {
    private static int[][] giveUps = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, 
                                      {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == giveUps[j][i % giveUps[j].length]) {
                    scores[j] += 1;
                }
            }
        }
        
        // 최대 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최대 점수를 받은 사람을 리스트에 추가
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                resultList.add(i + 1); // 인덱스가 0부터 시작하므로 +1
            }
        }
        
        Collections.sort(resultList);
        
        // 리스트를 배열로 변환하여 반환
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}