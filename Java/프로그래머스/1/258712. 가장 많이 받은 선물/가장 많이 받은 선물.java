import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        // 친구 이름을 인덱스로 매핑
        Map<String, Integer> friendToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendToIndex.put(friends[i], i);
        }
        
        // 각 친구별로 준 선물과 받은 선물의 수를 기록
        int[] giftGiven = new int[n];
        int[] giftReceived = new int[n];
        
        // 두 친구 간 선물 교환 횟수를 저장하는 2차원 배열
        int[][] count = new int[n][n];
        
        // 선물 기록 처리
        for (String record : gifts) {
            String[] parts = record.split(" ");
            String sender = parts[0];
            String receiver = parts[1];
            int si = friendToIndex.get(sender);
            int ri = friendToIndex.get(receiver);
            giftGiven[si]++;
            giftReceived[ri]++;
            count[si][ri]++;
        }
        
        // 각 친구의 선물 지수 계산: (자신이 준 선물 수) - (받은 선물 수)
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = giftGiven[i] - giftReceived[i];
        }
        
        // 다음 달 각 친구가 받게 될 선물 수를 계산
        int[] nextMonthReceived = new int[n];
        
        // 모든 서로 다른 친구 쌍(i, j) 처리 (unordered pair)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt1 = count[i][j]; // 친구 i가 j에게 준 횟수
                int cnt2 = count[j][i]; // 친구 j가 i에게 준 횟수
                
                // 둘 사이에 선물 교환 기록이 있고, 횟수가 다르다면
                if ((cnt1 + cnt2) > 0 && cnt1 != cnt2) {
                    // 더 많이 준 사람이 다음 달에 선물을 받음
                    if (cnt1 > cnt2) {
                        nextMonthReceived[i]++;
                    } else {
                        nextMonthReceived[j]++;
                    }
                } else {
                    // 선물 교환 기록이 없거나 횟수가 같다면 선물 지수를 비교
                    if (giftIndex[i] != giftIndex[j]) {
                        if (giftIndex[i] > giftIndex[j]) {
                            nextMonthReceived[i]++;
                        } else {
                            nextMonthReceived[j]++;
                        }
                    }
                    // 선물 지수도 같다면 아무 일도 일어나지 않음.
                }
            }
        }
        
        // 다음 달 가장 많은 선물을 받게 될 친구의 선물 수 반환
        int maxGifts = 0;
        for (int i = 0; i < n; i++) {
            maxGifts = Math.max(maxGifts, nextMonthReceived[i]);
        }
        return maxGifts;
    }
}