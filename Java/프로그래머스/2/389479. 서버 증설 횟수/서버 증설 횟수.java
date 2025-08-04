class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] capacities = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            while (players[i] >= capacities[i]+m) {
                increaseCapacity(i, capacities, m, k);
                answer++;
            }
        }
        return answer;
    }
    
    private void increaseCapacity(int current, int[] capacities, int m, int k) {
        for (int i = current; i < current+k; i++) {
            if (i < capacities.length) {
                capacities[i] += m;
            }
        }
    }
}