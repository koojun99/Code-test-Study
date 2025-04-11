import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 보드 입력 받기 (N x N 보드)
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            board[i] = s.toCharArray();
        }

        int answer = 0;
        // 보드 전체에 대해 가능한 스왑을 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽 칸과 스왑 가능하면
                if (j + 1 < N && board[i][j] != board[i][j+1]) {
                    swap(board, i, j, i, j+1);
                    answer = Math.max(answer, checkBoard(board));
                    swap(board, i, j, i, j+1);  // 원래 상태로 복원
                }
                // 아래쪽 칸과 스왑 가능하면
                if (i + 1 < N && board[i][j] != board[i+1][j]) {
                    swap(board, i, j, i+1, j);
                    answer = Math.max(answer, checkBoard(board));
                    swap(board, i, j, i+1, j);  // 원래 상태로 복원
                }
            }
        }

        System.out.println(answer);
    }

    // 두 좌표의 문자를 교환하는 함수
    static void swap(char[][] board, int i1, int j1, int i2, int j2) {
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }

    // 보드 내 모든 행과 열에서 연속으로 같은 색 사탕의 최대 개수를 반환하는 함수
    static int checkBoard(char[][] board) {
        int N = board.length;
        int maxCount = 0;

        // 각 행 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j-1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        // 각 열 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i-1][j]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
