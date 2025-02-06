import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 최적화를 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 최적화를 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // n 읽기
            int n = Integer.parseInt(br.readLine());
            // n개의 숫자가 공백으로 구분되어 들어오는 한 줄 읽기
            String[] nums = br.readLine().split(" ");
            // HashSet을 사용해 평균 O(1) 검색 시간 확보
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(nums[i]));
            }

            // m 읽기
            int m = Integer.parseInt(br.readLine());
            // m개의 쿼리 숫자가 공백으로 들어오는 한 줄 읽기
            String[] queries = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                int current = Integer.parseInt(queries[i]);
                if (set.contains(current)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        // 모든 출력을 flush하여 한 번에 출력
        bw.flush();
        br.close();
        bw.close();
    }
}