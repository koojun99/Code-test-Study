import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        int flats = sc.nextInt();
        sc.nextLine();
        int answer = 0;

        Stack<Integer>[] stacks = new Stack[lines+1];
        for (int i = 1; i <= lines; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 0; i < lines; i++) {
            int line = sc.nextInt();
            int flat = sc.nextInt();

            while (!stacks[line].isEmpty() && stacks[line].peek() > flat) {
                stacks[line].pop();
                answer++;
            }

            if (stacks[line].isEmpty() || stacks[line].peek() < flat) {
                stacks[line].push(flat);
                answer++;
            }
        }

        System.out.println(answer);
    }

}