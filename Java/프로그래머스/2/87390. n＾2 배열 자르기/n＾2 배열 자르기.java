class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left + 1);
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            long index = left + i;
            int row = (int)(index / n);
            int col = (int)(index % n);
            answer[i] = Math.max(row, col) + 1;
        }
        return answer;
    }
}