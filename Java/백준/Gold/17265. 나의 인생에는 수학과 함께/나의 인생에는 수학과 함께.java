import java.util.*;

public class Main {
    static int n;
    static String[][] board;
    static int[][] maxDP, minDP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next();
            }
        }

        maxDP = new int[n][n];
        minDP = new int[n][n];
        for (int[] row : maxDP) Arrays.fill(row, Integer.MIN_VALUE);
        for (int[] row : minDP) Arrays.fill(row, Integer.MAX_VALUE);

        // 시작 칸은 숫자
        int startVal = Integer.parseInt(board[0][0]);
        maxDP[0][0] = startVal;
        minDP[0][0] = startVal;

        // DP 진행 (행/열 순회)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (isNumber(i, j)) {
                    int curNum = Integer.parseInt(board[i][j]);

                    // 위에서 내려올 때: 위가 연산자여야 함
                    if (i > 0 && !isNumber(i - 1, j)) {
                        char op = board[i - 1][j].charAt(0);
                        // 연산자칸 (i-1,j) 에 저장된 값은 그 전 숫자칸의 min/max가 복사되어 있음
                        int cand1 = apply(op, maxDP[i - 1][j], curNum);
                        int cand2 = apply(op, minDP[i - 1][j], curNum);
                        maxDP[i][j] = Math.max(maxDP[i][j], Math.max(cand1, cand2));
                        minDP[i][j] = Math.min(minDP[i][j], Math.min(cand1, cand2));
                    }

                    // 왼쪽에서 올 때: 왼쪽이 연산자여야 함
                    if (j > 0 && !isNumber(i, j - 1)) {
                        char op = board[i][j - 1].charAt(0);
                        int cand1 = apply(op, maxDP[i][j - 1], curNum);
                        int cand2 = apply(op, minDP[i][j - 1], curNum);
                        maxDP[i][j] = Math.max(maxDP[i][j], Math.max(cand1, cand2));
                        minDP[i][j] = Math.min(minDP[i][j], Math.min(cand1, cand2));
                    }
                } else {
                    // 연산자 칸: 값 변동 없음 → 위/왼 숫자칸의 min/max를 "운반"
                    if (i > 0 && isNumber(i - 1, j)) {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i - 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i - 1][j]);
                    }
                    if (j > 0 && isNumber(i, j - 1)) {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][j - 1]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][j - 1]);
                    }
                }
            }
        }

        System.out.println(maxDP[n - 1][n - 1] + " " + minDP[n - 1][n - 1]);
    }

    static boolean isNumber(int i, int j) {
        // 입력이 모두 한 글자라면 Character로 판단해도 되고, 일반적으로는 try-parse
        // 여기서는 숫자/연산자가 공백으로 구분되어 들어온다고 가정해 숫자 문자열로 판단
        char c = board[i][j].charAt(0);
        return (c == '-') ? board[i][j].length() > 1 : Character.isDigit(c);
    }

    static int apply(char op, int a, int b) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        // op == '*'
        return a * b;
    }
}