import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            getBitPostition(num);
        }
    }

    private static void getBitPostition(int num) {
        List<Integer> positions = new ArrayList<>();
        String binary = Integer.toBinaryString(num);
        char[] bits = binary.toCharArray();
        for (int i = bits.length-1; i >= 0; i--) {
            if (bits[i] == '1') {
                positions.add(bits.length-1-i);
            }
        }

        for(int position : positions) {
            System.out.print(position + " ");
        }
    }
}