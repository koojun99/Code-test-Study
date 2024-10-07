class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int diff = common[1] - common[0];
        int ratio = 0;
        if (common[0] != 0){
            ratio = common[1] / common[0];
        }
        
        boolean isDeungCha = true;
        boolean isDeungBi = true;
        
        for (int i = 1; i < common.length; i++) {
            if ((common[i] - common[i-1]) != diff) {
                isDeungCha = false;
            }
            
            if (common[i-1] == 0 ||(common[i] / common[i-1]) != ratio || common[i] % common[i-1] != 0) {
                isDeungBi = false;
            }
        }
        
        if (isDeungCha) {
            answer = common[common.length-1] + diff;
        }
        
        if (isDeungBi) {
            answer = common[common.length-1] * ratio;
        }
        
        return answer;
    }
}