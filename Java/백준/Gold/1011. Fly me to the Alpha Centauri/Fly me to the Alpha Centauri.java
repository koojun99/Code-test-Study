import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int dist = to - from;

            sb.append(calculate(dist)).append('\n');
        }

        System.out.print(sb);
    }

    private static int calculate(int dist) {
        int k = (int) Math.sqrt(dist); // 빠르게 sqrt 계산

        if (dist == k * k) return 2 * k - 1;
        else if (dist <= k * k + k) return 2 * k;
        else return 2 * k + 1;
    }
}