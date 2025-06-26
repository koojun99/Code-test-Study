class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder full = new StringBuilder();
        int num = 0;

        // 필요한 길이만큼 숫자 누적
        while (full.length() < t * m) {
            full.append(Integer.toString(num++, n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(full.charAt(i * m + (p - 1)));
        }

        return answer.toString();
    }
}