import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coins = 0;

        int changeMoney = sc.nextInt();

        while (changeMoney >= 0) {
            if (changeMoney % 5 == 0) {
                coins += changeMoney / 5;
                System.out.println(coins);
                return;
            }
            changeMoney -= 2;
            coins++;
        }

        System.out.println(-1);
    }
}


