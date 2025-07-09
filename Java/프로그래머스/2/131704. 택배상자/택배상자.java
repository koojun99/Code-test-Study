import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int box = 1;  // 현재 컨베이어 벨트에서 오는 상자 번호
        int idx = 0;  // 현재 배송하려는 order의 인덱스

        while (box <= order.length) {
            if (box == order[idx]) {
                idx++;      // 바로 배송
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;      // 보조 컨테이너에서 배송
                continue;   // 다시 같은 box 번호로 비교
            } else {
                stack.push(box);  // 보조 컨테이너로 이동
            }
            box++;
        }

        // 스택에 남아있는 애들 중에서도 배송 가능한 애들 처리
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
        }

        return idx;  // 배송한 상자 수
    }
}