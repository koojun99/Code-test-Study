import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(sc.nextInt());
        }

        int m = sc.nextInt();
        int[] setB = new int[m];
        for (int i = 0; i < m; i++) {
            setB[i] = sc.nextInt();
        }

        for (int num : setB) {
            if (setA.contains(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
