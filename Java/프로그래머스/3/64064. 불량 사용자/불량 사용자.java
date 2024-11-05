import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String ban : bans[index]) {
            if (banned.contains(ban)) {
                continue;
            }
            banned.add(ban);
            count(index + 1, banned, bans, banSet);
            banned.remove(ban);
        }
    }
}