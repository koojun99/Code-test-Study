class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        Count result = compression(0, 0, n, arr); // 전체 배열에 대해 압축
        return new int[]{result.zeros, result.ones}; // 최종 결과 배열로 반환
    }

    class Count {

        private int zeros;
        private int ones;

        public Count(int zeros, int ones) {
            this.zeros = zeros;
            this.ones = ones;
        }

        public void add(Count count) {
            this.zeros += count.zeros;
            this.ones += count.ones;
        }
    }

    public Count compression(int offsetX, int offsetY, int n, int[][] arr) {
        int h = n / 2;
        int start = arr[offsetX][offsetY];

        if (n == 1) {
            if (start == 1) {
                return new Count(0, 1);
            }
            else return new Count(1, 0);
        }

        for (int i = offsetX; i < offsetX+n; i++) {
            for (int j = offsetY; j < offsetY+n; j++) {
                if (arr[i][j] != start) {
                    Count topLeft = compression(offsetX, offsetY, h, arr);
                    Count topRight = compression(offsetX, offsetY + h, h, arr);
                    Count bottomLeft = compression(offsetX + h, offsetY, h, arr);
                    Count bottomRight = compression(offsetX + h, offsetY + h, h, arr);

                    // 결과를 합친 후 반환
                    topLeft.add(topRight);
                    topLeft.add(bottomLeft);
                    topLeft.add(bottomRight);
                    return topLeft;
                }
            }
        }

        // 모든 값이 동일하면 해당 값에 맞는 Count 객체 반환
        if (start == 1) {
            return new Count(0, 1); // 모든 값이 1인 경우
        } else {
            return new Count(1, 0); // 모든 값이 0인 경우
        }
    }
}