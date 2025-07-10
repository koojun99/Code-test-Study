import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> skillOrder = new ArrayList<>();
        for (char c : skill.toCharArray()) {
            skillOrder.add(c);
        }

        for (String skill_tree : skill_trees) {
            int idx = 0;
            boolean isValid = true;
            for (char ch : skill_tree.toCharArray()) {
                if (!skillOrder.contains(ch)) continue; // 상관없는 스킬은 무시
                if (ch != skillOrder.get(idx)) {
                    isValid = false; // 순서 어김
                    break;
                }
                idx++; // 다음 선행스킬로 이동
            }
            if (isValid) answer++;
        }

        return answer;
    }
}