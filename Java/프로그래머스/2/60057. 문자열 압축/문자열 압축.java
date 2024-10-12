import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            int compressed = compress(s, i);
            if (compressed < min) {
                min = compressed;
            }
        }

        return min;
    }
    
    private int compress(String source, int len) {
        StringBuilder sb = new StringBuilder();
        String lastToken = "";
        int count = 1;
        for (String token : split(source, len)) {
            if (token.equals(lastToken)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(lastToken);
                count = 1;
                lastToken = token;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(lastToken);
        return sb.length();
    }

    private List<String> split(String source, int len) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < source.length(); i += len) {
            int end = i + len;
            if (end > source.length()) end = source.length();
            tokens.add(source.substring(i, end));
        }
        return tokens;
    }
}