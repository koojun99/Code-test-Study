import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            String input = sc.nextLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();

            for (char ch : input.toCharArray()) {
                if (ch == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (ch == '>') {
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else if (ch == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else {
                    cursor.add(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }
}