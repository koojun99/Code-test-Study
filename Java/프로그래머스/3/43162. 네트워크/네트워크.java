class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer += 1;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int index) {
        visited[index] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}