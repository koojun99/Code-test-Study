import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;
        if (num == 0) {
            System.out.println(answer);
            return;
        }

        answer = fibo(num);
        System.out.println(answer);
    }


    private static int fibo(int num) {
        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 1;
        }

        return fibo(num - 1) + fibo(num - 2);
    }
}