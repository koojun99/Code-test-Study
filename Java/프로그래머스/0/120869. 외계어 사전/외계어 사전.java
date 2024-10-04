class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(String word : dic) {
            String tempWord = word;  // 단어의 복사본을 생성
            boolean isValid = true;

            // spell 배열의 모든 문자를 단어에서 제거
            for (String s : spell) {
                if (tempWord.contains(s)) {
                    tempWord = tempWord.replaceFirst(s, "");  // 첫 번째 해당 문자를 제거
                } else {
                    isValid = false;
                    break;  // spell에 있는 문자가 없으면 바로 중단
                }
            }

            // 모든 문자가 한 번씩만 사용된 경우
            if (isValid && tempWord.isEmpty()) {
                return 1;  // 일치하는 단어가 있으면 1 반환
            }
        }
        return answer;
    }
}