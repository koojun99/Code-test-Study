import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        List<Integer> answer = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            for (int i = 1; i <= k; i++) {
                if (i != k) {
                    int num = linkedList.pollFirst();
                    linkedList.addLast(num);
                } else {
                    answer.add(linkedList.pollFirst());
                }
            }
        }
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if (i != answer.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}