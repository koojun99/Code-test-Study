import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 해시맵 생성
        Map<String, Integer> numbers = new HashMap<>();
        
        // 모든 번호를 해시맵에 저장
        for (String number : phone_book) {
            numbers.put(number, 1);
        }
        
        // 각 번호에 대해 접두사를 검사
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                // 부분 문자열로 접두사가 해시맵에 존재하는지 확인
                if (numbers.containsKey(number.substring(0, i))) {
                    return false;  // 접두사가 존재하면 false 반환
                }
            }
        }
        
        return true;
    }
}
