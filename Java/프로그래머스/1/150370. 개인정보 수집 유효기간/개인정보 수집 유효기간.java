import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        
        LocalDate currentDate = LocalDate.parse(today, formatter);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArr = privacies[i].split(" ");
            LocalDate collectionDate = LocalDate.parse(privacyArr[0], formatter); // 수집 날짜
            String termType = privacyArr[1]; // 약관 종류
            
            int validMonths = termMap.get(termType);
            LocalDate expirationDate = collectionDate.plusMonths(validMonths);
            
            // 만료 날짜와 현재 날짜 비교
            if (expirationDate.isBefore(currentDate) || expirationDate.isEqual(currentDate)) {
                answer.add(i + 1); // 파기 대상
            }
            
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}