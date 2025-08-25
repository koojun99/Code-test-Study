import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt();
        int nb = sc.nextInt();

        int[] a = new int[na];
        int[] b = new int[nb];

        for (int i = 0; i < na; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < nb; i++) {
            b[i] = sc.nextInt();
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result.add(a[i++]);
            } else if (a[i] > b[j]) {
                j++;
            } else { // 같으면 제거
                i++;
                j++;
            }
        }
        // 남은 A 추가
        while (i < a.length) result.add(a[i++]);

        System.out.println(result.size());
        for (int k = 0; k < result.size(); k++) {
            System.out.print(result.get(k) + " ");
        }
    }
}
