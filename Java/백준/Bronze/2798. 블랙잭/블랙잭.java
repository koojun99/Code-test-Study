import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] cards = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        Arrays.sort(cards);
        int len = cards.length;

        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                for (int k = i+2; k < len; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum == target) {
                        answer = sum;
                        break;
                    } else if (sum < target) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        System.out.println(answer);

    }
}