import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] patternText = sc.nextLine().split("\\*");
        String prefix = patternText[0];
        String suffix = patternText[1];


        for (int i = 0; i < n; i++) {
            String fileName = sc.nextLine();
            // 파일 이름의 길이가 prefix와 suffix의 총 길이보다 작으면 무조건 매칭 안 됨
            if (fileName.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
            } else if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
                // prefix로 시작하고 suffix로 끝나면 패턴에 매칭됨
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

}