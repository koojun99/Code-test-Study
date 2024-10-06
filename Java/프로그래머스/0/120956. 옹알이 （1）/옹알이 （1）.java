class Solution {
    public int solution(String[] babbling) {
        String[] availables = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String b : babbling) {
            String prevPattern = "";
            boolean isValid = true;  // 유효한 단어인지 체크
            while (!b.equals("")) {
                boolean found = false;
                
                for (String pattern : availables) {
                    if (b.startsWith(pattern)) {
                        // 연속된 같은 패턴 방지
                        if (pattern.equals(prevPattern)) {
                            isValid = false;
                            break;
                        }
                        
                        b = b.substring(pattern.length());  // 해당 패턴을 잘라냄
                        prevPattern = pattern;  // 이전 패턴 업데이트
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    isValid = false;  // 허용된 패턴이 아닌 경우
                    break;
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        return answer;
    }
}