import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pillars = new int[n][2];

        int maxHeight = 0;
        int maxX = 0;
        int minX = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int h = sc.nextInt();
            pillars[i] = new int[]{x, h};
            maxHeight = Math.max(maxHeight, h);
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
        }

        // 높이 배열 구성
        int[] height = new int[maxX + 2]; // x좌표가 1 이상 ~ 1000 이하라고 가정

        for (int[] p : pillars) {
            height[p[0]] = p[1];
        }

        int area = 0;
        int[] leftMax = new int[maxX + 2];
        int[] rightMax = new int[maxX + 2];

        // 왼쪽에서 오른쪽
        leftMax[minX] = height[minX];
        for (int i = minX + 1; i <= maxX; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 오른쪽에서 왼쪽
        rightMax[maxX] = height[maxX];
        for (int i = maxX - 1; i >= minX; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 최소 높이 중 최댓값 선택
        for (int i = minX; i <= maxX; i++) {
            area += Math.min(leftMax[i], rightMax[i]);
        }

        System.out.println(area);
    }
}