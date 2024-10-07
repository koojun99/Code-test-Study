class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        char[] charA = A.toCharArray();
        
        while(answer < A.length()) {
            if (new String(charA).equals(B)) break;
            char last = charA[charA.length-1];
            for (int i = charA.length-1; i >= 1; i--) {
                charA[i] = charA[i-1];
            }
            charA[0] = last;
            
            answer += 1;
        }
        
        if (!new String(charA).equals(B)) return -1;
        return answer;
    }
}