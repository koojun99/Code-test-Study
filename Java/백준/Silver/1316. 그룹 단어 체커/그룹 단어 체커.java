import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // 남은 개행 소모

        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            if (isGroupWord(word)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        Set<Character> seen = new HashSet<>();
        char prev = 0;
        for (char c : word.toCharArray()) {
            if (c != prev) {
                // 이전에 본 적 있다면 invalid
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
                prev = c;
            }
            // c == prev 면 연속 출현이므로 그냥 넘어감
        }
        return true;
    }
}
