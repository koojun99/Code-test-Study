import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        if (n == 1) {
            answer = 1;
        } else if (n == 2) {
            answer = Math.min(4, (m+1)/2);
        } else {
            if (m < 7) {
                answer = Math.min(4, m);
            }
            else {
                answer = m-2;
            }
        }
        System.out.println(answer);
    }

}