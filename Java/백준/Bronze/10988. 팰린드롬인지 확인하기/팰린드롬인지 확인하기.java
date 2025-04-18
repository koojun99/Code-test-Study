import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] letters = sc.nextLine().split("");
        int n = letters.length;
        int answer = 1;
        for (int i = 0; i < n/2; i++) {
            if (!letters[i].equals(letters[n-1-i])){
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }

}
