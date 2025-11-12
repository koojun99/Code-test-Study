import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initial = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> cursor = list.listIterator();
        for (char ch : initial.toCharArray()) {
            cursor.add(ch);
        }

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String command = br.readLine();

            if (command.startsWith("P")) {
                char letter = command.charAt(2);
                cursor.add(letter);
            } else if (command.equals("L")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (command.equals("D")) {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (command.equals("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
        }

        // 빠른 출력
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}