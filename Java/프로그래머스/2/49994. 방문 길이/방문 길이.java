import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        int answer = 0;

        // 상하좌우 정의
        Map<Character, int[]> direction = new HashMap<>();
        direction.put('U', new int[]{0, 1});
        direction.put('D', new int[]{0, -1});
        direction.put('L', new int[]{-1, 0});
        direction.put('R', new int[]{1, 0});

        for (char c : dirs.toCharArray()) {
            int nx = x + direction.get(c)[0];
            int ny = y + direction.get(c)[1];

            // 좌표가 [-5, 5] 범위를 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            // 경로를 문자열로 저장 (양방향 둘 다 체크)
            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;

            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}