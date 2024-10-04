class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int rows = board.length;
        int cols = board[0].length;

        // 주변을 위험 지역으로 표시
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    markDangerous(i, j, board, rows, cols);
                }
            }
        }
        
        // 위험하지 않은 지역을 카운트
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
    
    public void markDangerous(int x, int y, int[][] board, int rows, int cols) {
        for (int i = Math.max(0, x-1); i <= Math.min(rows-1, x+1); i++) {
            for (int j = Math.max(0, y-1); j <= Math.min(cols-1, y+1); j++) {
                if (board[i][j] == 0) {
                    board[i][j] = -1;  // 위험 지역으로 마크
                }
            }
        }
    }
}