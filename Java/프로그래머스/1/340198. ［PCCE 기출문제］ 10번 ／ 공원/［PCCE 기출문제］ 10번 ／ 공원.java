import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // mats에 있는 돗자리 크기를 내림차순으로 정렬합니다.
        Arrays.sort(mats);
        // 내림차순으로 순회하며 해당 크기의 돗자리를 깔 수 있는지 검사합니다.
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if (canPlaceMat(park, size)) {
                return size;
            }
        }
        return -1;
    }
    
    // park에서 side x side 크기의 정사각형 영역이 모두 "-1"인지 확인하는 메서드
    private boolean canPlaceMat(String[][] park, int side) {
        int rows = park.length;
        int cols = park[0].length;
        // 시작점 (i, j)에서 side 크기의 정사각형이 공원 내부에 완전히 포함되는지 순회
        for (int i = 0; i <= rows - side; i++) {
            for (int j = 0; j <= cols - side; j++) {
                boolean valid = true;
                // (i,j)에서 시작하는 side x side 영역의 모든 셀이 "-1"인지 확인
                for (int r = i; r < i + side; r++) {
                    for (int c = j; c < j + side; c++) {
                        if (!park[r][c].equals("-1")) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }
                if (valid) return true;
            }
        }
        return false;
    }
}