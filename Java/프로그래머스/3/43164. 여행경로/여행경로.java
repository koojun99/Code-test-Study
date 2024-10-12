import java.util.*;

class Solution {
    
    public String[] solution(String[][] tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        // 티켓 정보를 HashMap에 저장 (출발지 -> 목적지 리스트)
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            flightMap.putIfAbsent(from, new ArrayList<>());
            flightMap.get(from).add(to);
        }
        
        // 각 출발지에 대해 목적지 리스트를 알파벳 순으로 정렬
        for (List<String> destList : flightMap.values()) {
            Collections.sort(destList);
        }
        
        
        
         // 경로 탐색 시작
        dfs("ICN", flightMap, answer, tickets.length + 1);

        return answer.stream().toArray(String[]::new);
    }
    
    private boolean dfs(String current, Map<String, List<String>> flightMap, List<String> answer, int targetLen) {
        // 경로에 현재 위치 추가
        answer.add(current);
        
        // 모든 티켓을 사용한 경우 (목표 경로 길이와 같아지면 종료)
        if (answer.size() == targetLen) {
            return true;
        }

        // 목적지 리스트에서 방문할 수 있는 공항 순회
        if (flightMap.containsKey(current)) {
            List<String> destinations = flightMap.get(current);
            
            // 목적지 순차적으로 탐색하면서 경로를 찾음
            for (int i = 0; i < destinations.size(); i++) {
                String next = destinations.remove(i); // 목적지를 사용하고 제거
                if (dfs(next, flightMap, answer, targetLen)) {
                    return true;
                }
                destinations.add(i, next); // 경로가 맞지 않으면 목적지를 되돌림
            }
        }
        
        // 경로가 맞지 않으면 현재 위치 제거
        answer.remove(answer.size() - 1);
        return false;
    }
    
    
}