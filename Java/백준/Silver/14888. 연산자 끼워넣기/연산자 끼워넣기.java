import java.io.*;
import java.util.*;

public class Main {
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // operators[0] : '+', [1] : '-', [2] : '*', [3] : '/'
        int[] operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(1, nums[0], nums, operators);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // index: 현재까지 사용한 숫자 개수(다음에 사용할 숫자의 인덱스)
    // current: 현재까지 계산된 결과값
    private static void dfs(int index, int current, int[] nums, int[] operators) {
        if (index == nums.length) {
            maxResult = Math.max(maxResult, current);
            minResult = Math.min(minResult, current);
            return;
        }

        // 각 연산자에 대해
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 해당 연산자 사용

                int nextResult = current;
                int nextNum = nums[index];
                if (i == 0) { // +
                    nextResult = current + nextNum;
                } else if (i == 1) { // -
                    nextResult = current - nextNum;
                } else if (i == 2) { // *
                    nextResult = current * nextNum;
                } else if (i == 3) { // /
                    // 문제에서 음수 나눗셈에 대한 조건이 있을 수 있음(자바의 정수 나눗셈은 음수에서도 몫을 내림)
                    nextResult = current / nextNum;
                }

                dfs(index + 1, nextResult, nums, operators);
                operators[i]++; // 백트래킹: 연산자 개수 복원
            }
        }
    }
}