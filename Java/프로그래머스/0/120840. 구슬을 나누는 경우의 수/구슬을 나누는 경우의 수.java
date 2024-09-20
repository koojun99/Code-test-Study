class Solution {
    public int solution(int balls, int share) {
        double result = 1;
        
        // 조합 공식을 사용해 (balls! / share!) 부분을 계산합니다.
        // (share+1) * (share+2) * ... * (balls)
        for (int i = share + 1; i <= balls; i++) {
            result *= i;
        }
        
        // 나누기 부분 (balls-share)!를 계산합니다.
        // 여기서는 간단히 for 루프를 통해 순차적으로 나누는 방식으로 최적화합니다.
        for (int i = 2; i <= balls - share; i++) {
            result /= i;
        }
        
        // 결과를 반올림하여 int로 변환하여 반환합니다.
        return (int)Math.round(result);

    }
}