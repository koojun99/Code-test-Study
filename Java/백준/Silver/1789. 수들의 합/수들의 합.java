import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long num = sc. nextLong();
        long answer = 1;

        while ( (answer * (answer + 1)) / 2 <= num ) {
            answer++;
        }
        // while문을 탈출할 때 answer는 조건을 만족하지 않는 첫 번째 값이므로, 최대 k는 answer - 1
        System.out.println(answer - 1);
           
    }

}