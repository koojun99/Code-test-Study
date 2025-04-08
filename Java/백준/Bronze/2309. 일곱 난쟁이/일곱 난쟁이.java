import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarves = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            dwarves[i] = sc.nextInt();
            total += dwarves[i];
        }

        int heightToRemove = total - 100;
        boolean found = false;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < 9 && !found; i++) {
            for (int j = i+1; j < 9 && !found; j++) {
                if (dwarves[i] + dwarves[j] == heightToRemove) {
                    index1 = i;
                    index2 = j;
                    found = true;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) {
                continue;
            }

            answer.add(dwarves[i]);
        }

        Collections.sort(answer);
        for (int i = 0; i < 7; i++) {
            System.out.println(answer.get(i));
        }
    }
}