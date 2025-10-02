import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 최대 숫자
        m = sc.nextInt(); // 고를 개수

        backtrack(1, new ArrayList<>());
    }

    private static void backtrack(int start, List<Integer> current) {
        if (current.size() == m) {
            for (int num : current) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, current); // 다음 숫자부터 탐색 (조합)
            current.remove(current.size() - 1); // 백트래킹
        }
    }
}