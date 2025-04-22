import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String number = input[0];
        int base = Integer.parseInt(input[1]);

        int answer = 0;
        int multiply = 1;
        for (int i = number.length()-1; i >= 0; i--) {
            int value = calculateValue(number.charAt(i));
            answer += value * multiply;
            multiply *= base;
        }

        System.out.println(answer);
    }

    private static int calculateValue(char num) {
        int value = 0;
        if (num >= '0' && num <= '9') {
            value = num - '0';
        }
        if (num >= 'A' && num <= 'Z') {
            value = num - 'A' + 10;
        }

        return value;
    }
}

