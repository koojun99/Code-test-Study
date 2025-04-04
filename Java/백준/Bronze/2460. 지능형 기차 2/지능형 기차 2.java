import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int maxPassengers = 0;

        int current = 0;
        for (int i = 0; i < 10; i++) {
            current -= sc.nextInt();
            current += sc.nextInt();
            maxPassengers = Math.max(maxPassengers, current);
        }

        System.out.println(maxPassengers);
    }
}
