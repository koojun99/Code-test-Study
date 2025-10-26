import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder(); // 🔸 한 번에 출력할 버퍼

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1부터 n까지
        m = sc.nextInt(); // 수열 길이

        backtrack(1, new ArrayList<>());
        System.out.print(sb); // 🔸 한 번에 출력
    }

    private static void backtrack(int start, List<Integer> current) {
        if (current.size() == m) {
            for (int num : current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i, current);
            current.remove(current.size() - 1);
        }
    }
}