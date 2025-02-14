import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 최적화를 위한 BufferedReader 사용 (입력이 많을 경우)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        int left = 0;  // left를 강의 중 가장 긴 길이로 초기화
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lectures[i]);
        }
        
        int right = 1000000000; // 문제에서 주어진 최대 녹화 용량 범위
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int cnt = 1; // 최소 1개의 그룹은 존재
            
            // 강의를 순회하며 mid 용량으로 녹화 시 몇 개의 그룹(구간)이 필요한지 계산
            for (int i = 0; i < n; i++) {
                if (sum + lectures[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += lectures[i];
            }
            
            if (cnt <= m) {
                answer = mid; // 가능한 녹화 용량 갱신
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}
