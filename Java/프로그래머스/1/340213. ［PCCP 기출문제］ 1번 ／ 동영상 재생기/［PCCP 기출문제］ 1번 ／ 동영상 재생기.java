class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // pos, op_start, op_end를 초 단위로 변환
        String[] posParts = pos.split(":");
        int currentSeconds = Integer.parseInt(posParts[0]) * 60 + Integer.parseInt(posParts[1]);
        
        String[] opStartParts = op_start.split(":");
        int opStartSeconds = Integer.parseInt(opStartParts[0]) * 60 + Integer.parseInt(opStartParts[1]);
        
        String[] opEndParts = op_end.split(":");
        int opEndSeconds = Integer.parseInt(opEndParts[0]) * 60 + Integer.parseInt(opEndParts[1]);
        
        String[] videoParts = video_len.split(":");
        int videoSeconds = Integer.parseInt(videoParts[0]) * 60 + Integer.parseInt(videoParts[1]);
        
        // 현재 위치가 op_start와 op_end 사이면 자동으로 op_end로 이동
        if (currentSeconds >= opStartSeconds && currentSeconds < opEndSeconds) {
            currentSeconds = opEndSeconds;
        }
        // 각 커맨드를 처리하면서, 커맨드 후 현재 위치가 [op_start, op_end) 범위면 op_end로 점프
        for (String command : commands) {
            
            if (command.equals("prev")) {
                currentSeconds -= 10;
                if (currentSeconds < 0) { // 영상의 처음을 넘으면 0으로 처리
                    currentSeconds = 0;
                }
            } else if (command.equals("next")) {
                currentSeconds += 10;
                if (currentSeconds > videoSeconds) { // 영상의 마지막을 넘으면 video_len으로 처리
                    currentSeconds = videoSeconds;
                }
            }

            // 현재 위치가 op_start와 op_end 사이면 자동으로 op_end로 이동
            if (currentSeconds >= opStartSeconds && currentSeconds < opEndSeconds) {
                currentSeconds = opEndSeconds;
            }
            
        }
        
        // 최종 시간(초)를 분과 초로 변환 (초가 10 미만이면 앞에 0 추가)
        int finalMinute = currentSeconds / 60;
        int finalSecond = currentSeconds % 60;
        String secondsStr = (finalSecond < 10 ? "0" : "") + finalSecond;
        String minutesStr = (finalMinute < 10 ? "0": "") + finalMinute;
        
        return minutesStr + ":" + secondsStr;
    }
}