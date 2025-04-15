import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> sequence = new ArrayList<>();
        int value = 1;   // 값 1부터 시작: 1, 2, 3, 4, ...
        while (sequence.size() < b) {
            // value를 value번 반복해서 추가
            for (int i = 0; i < value && sequence.size() < b; i++) {
                sequence.add(value);
            }
            value++;
        }

        long sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += sequence.get(i);
        }

        System.out.println(sum);
    }

}
