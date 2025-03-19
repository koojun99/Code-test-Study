class Solution {
    private int toMinutes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return hour * 60 + minute;
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int count = 0;
        
        // 각 직원마다 처리
        for (int i = 0; i < n; i++) {
            // 출근 희망 시각을 분으로 변환하고 10분 추가 → 허용 시각
            int allowed = toMinutes(schedules[i]) + 10;
            boolean qualifies = true;
            
            // 7일간의 기록 검사
            for (int j = 0; j < 7; j++) {
                // 요일 계산: 1(월)~7(일)
                int dayOfWeek = ((startday - 1 + j) % 7) + 1;
                // 토요일(6)과 일요일(7)은 검사하지 않음
                if (dayOfWeek == 6 || dayOfWeek == 7) continue;
                
                int actual = toMinutes(timelogs[i][j]);
                // 평일에 출근 시간이 허용 시각을 초과하면 자격 상실
                if (actual > allowed) {
                    qualifies = false;
                    break;
                }
            }
            if (qualifies) count++;
        }
        
        return count;
    }
}