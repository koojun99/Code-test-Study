import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> dividers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                dividers.add(i);
            }
        }

        if (dividers.size() <= k-1) {
            System.out.println(0);
            return;
        }

        else {System.out.println(dividers.get(k-1));}

    }
}