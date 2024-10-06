class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;  // 처음에 주문한 치킨 수가 곧 쿠폰 수

        // 쿠폰이 10장 이상일 때 계속해서 치킨을 받을 수 있음
        while (coupon >= 10) {
            int newChicken = coupon / 10;  // 쿠폰으로 받을 수 있는 치킨 수
            answer += newChicken;  // 받은 치킨 수 추가
            coupon = newChicken + (coupon % 10);  // 새로운 쿠폰 수 (남은 쿠폰 + 새로 받은 치킨의 쿠폰)
        }

        return answer;
    }
}