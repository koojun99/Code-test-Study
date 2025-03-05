class Solution {
    public int solution(int n, int w, int num) {
        // 필요한 층(행)의 수 계산 (마지막 행은 일부만 채워질 수 있음)
        int h = (n + w - 1) / w;
        
        int[][] grid = new int[h][w];
        int current = 1;
        
        // grid에 상자 번호를 지그재그(스네이크) 패턴으로 채우기
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) { // 짝수 행: 왼쪽 → 오른쪽
                for (int j = 0; j < w; j++) {
                    if (current > n) break;
                    grid[i][j] = current++;
                }
            } else { // 홀수 행: 오른쪽 → 왼쪽
                for (int j = w - 1; j >= 0; j--) {
                    if (current > n) break;
                    grid[i][j] = current++;
                }
            }
        }
        
        // target 상자(num)의 위치(행, 열)를 찾기
        int targetRow = -1, targetCol = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == num) {
                    targetRow = i;
                    targetCol = j;
                    break;
                }
            }
            if (targetRow != -1) break;
        }
        
        // target 상자와, target 상자 위쪽(즉, 행 번호가 targetRow보다 큰 행)
        // 에서 같은 열(targetCol)에 상자가 채워져 있는 경우만 count
        int answer = 1;  // target 상자 자신
        for (int i = targetRow + 1; i < h; i++) {
            if (grid[i][targetCol] != 0) {
                answer++;
            }
        }
        return answer;
    }
}