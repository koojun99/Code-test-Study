import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int n = input.length();
        int[] counts = new int[10];

        for (int i = 0; i < n; i++) {
            int num = input.charAt(i) - '0';
            counts[num]++;
        }
        int sixNine = (counts[6] + counts[9] + 1) / 2;

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            answer = Math.max(answer, counts[i]);
        }

        answer = Math.max(answer, sixNine);
        System.out.println(answer);
    }
}