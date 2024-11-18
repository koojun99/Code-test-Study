class Solution {
    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return maxDungeons;
    }

    private void dfs(int[][] dungeons, boolean[] visited, int k, int count) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 던전을 방문하지 않았고, 최소 피로도를 충족한다면
                visited[i] = true;
                dfs(dungeons, visited, k - dungeons[i][1], count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
