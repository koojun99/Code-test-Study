import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue; // 같은 열은 안됨
                    max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max; // 현재 위치에 이전 최대 점수 누적
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[n - 1][j]);
        }

        return answer;
    }
}