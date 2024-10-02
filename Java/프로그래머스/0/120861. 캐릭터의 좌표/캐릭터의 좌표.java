import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] current = {0, 0};
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};
        Map<String, Integer> keyMap = new HashMap<>();
        
        keyMap.put("left", 0);
        keyMap.put("up", 1);
        keyMap.put("right", 2);
        keyMap.put("down", 3);
        
        for (String input : keyinput) {
            int tempX = current[0] + moveX[keyMap.get(input)];
            int tempY = current[1] + moveY[keyMap.get(input)];
            int[] temp = {tempX, tempY};
            if (isAvailable(temp, board)) {
                current[0] = tempX;
                current[1] = tempY;
            }
        }

        return current;
    }
    
    public boolean isAvailable(int[] move, int[] board) {
        int moveX = move[0];
        int moveY = move[1];

        // 보드의 좌우 및 상하 크기 계산
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        // 좌표가 -maxX ~ maxX, -maxY ~ maxY 내에 있는지 확인
        return moveX >= -maxX && moveX <= maxX && moveY >= -maxY && moveY <= maxY;
    }
    
}