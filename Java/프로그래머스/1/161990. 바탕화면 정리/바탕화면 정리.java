class Solution {
    public int[] solution(String[] wallpaper) {
        int lux, luy;
        int rdx, rdy;
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        char[][] grid = new char[row][col];
        
        for (int i = 0; i < row; i++) {
            grid[i] = wallpaper[i].toCharArray();
        }
        
        lux = row;
        luy = col;
        rdx = 0;
        rdy = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}