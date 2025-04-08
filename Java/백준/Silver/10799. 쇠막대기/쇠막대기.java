import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (!stack.isEmpty() && input.charAt(i - 1) == '(') {
                    // 레이저의 경우: 이전 문자가 '('이면 레이저임
                    stack.pop(); // 레이저에 해당하는 '(' 제거하고
                    result += stack.size(); // 스택에 남은 '('의 개수만큼 조각 추가
                } else {
                    // 쇠막대기의 끝인 경우
                    stack.pop(); // 쇠막대기 시작 '(' 제거
                    result += 1; // 쇠막대기의 끝 조각 1 추가
                }
            }
        }
        System.out.println(result);
    }
}