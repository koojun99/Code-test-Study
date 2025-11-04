import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            pq.offer(input);
            if (input == 0) {
                System.out.println(pq.poll());
            }
        }
    }
}