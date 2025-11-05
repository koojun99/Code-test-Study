import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력: BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력: StringBuilder
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                String[] commands = input.split(" ");
                int num = Integer.parseInt(commands[1]);
                if (commands[0].equals("push_front")) {
                    deque.addFirst(num);
                } else {
                    deque.addLast(num);
                }
            } else if (input.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
            } else if (input.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
            } else if (input.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (input.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append('\n');
            } else if (input.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
            } else if (input.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
            }
        }

        // 한 번에 출력
        System.out.print(sb);
    }
}