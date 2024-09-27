class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        String[] smaller = {};
        String[] bigger = {};
        if (s1.length <= s2.length) {
            smaller = s1;
            bigger = s2;
        } else {
            smaller = s2;
            bigger = s1;
        }
        for (int i = 0; i < bigger.length; i++) {
            for (int j = 0; j < smaller.length; j++) {
                if (smaller[j].equals(bigger[i])) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}