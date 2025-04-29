import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        Arrays.sort(words, (a, b) -> b.length() - a.length());
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            boolean isValid = true;
            for (String str : answer) {
                if (word.startsWith(str) || str.startsWith(word)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                answer.add(word);
            }
        }

        System.out.println(answer.size());
    }
}
