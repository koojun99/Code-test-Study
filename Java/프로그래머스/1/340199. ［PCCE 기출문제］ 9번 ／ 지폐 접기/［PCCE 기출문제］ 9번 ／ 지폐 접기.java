class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        // 반복: 지폐가 지갑에 들어갈 때까지
        while (!fits(bill, wallet)) {
            // 항상 길이가 긴 쪽을 접습니다.
            if (bill[0] >= bill[1]) {
                bill[0] /= 2;  // 홀수면 소수점 이하 버림 (정수 나눗셈)
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
    
    private boolean fits(int[] bill, int[] wallet) {
        return (bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
               (bill[0] <= wallet[1] && bill[1] <= wallet[0]);
    }
}