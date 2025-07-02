import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 값이 아니라 인덱스를 저장

        for (int i = n - 1; i >= 0; i--) {
            int current = numbers[i];

            // 현재 값보다 작거나 같은 애들은 다 버림
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // 스택이 비어 있으면 뒤에 더 큰 수가 없음
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 숫자를 스택에 넣음
            stack.push(current);
        }

        return answer;
    }
}