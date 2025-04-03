import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] heights = new int[w];
        for (int i = 0; i < w; i++) {
            heights[i] = sc.nextInt();
        }

        // 좌측 최대값 배열 계산
        int[] leftMax = new int[w];
        leftMax[0] = heights[0];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]);
        }

        // 우측 최대값 배열 계산
        int[] rightMax = new int[w];
        rightMax[w-1] = heights[w-1];
        for (int i = w-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], heights[i]);
        }

        // 각 열마다 물이 차 있는 칸의 수 계산
        int answer = 0;
        for (int i = 0; i < w; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (water > 0) {
                answer += water;
            }
        }

        System.out.println(answer);
    }
}