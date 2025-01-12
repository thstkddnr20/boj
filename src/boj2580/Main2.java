package boj2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] board = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(1,1);
    }

    public static void recursion(int row, int col) {
        if (col == 9 && row == 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (row == 10) {
            recursion(1, col + 1);
            return;
        }

        if (board[col][row] == 0) {
            for (int i = 1; i < 10; i++) {
                if (isPossible(row, col, i)) {
                    board[col][row] = i;
                    recursion(row + 1, col);
                    board[col][row] = 0;
                }
            }
        }
        else {
            recursion(row + 1, col);
        }


    }

    static boolean isPossible(int row, int col, int num) { //row와 col에 num이 들어갈 수 있는지 확인

        //행 비교
        for (int i = 1; i < 10; i++) {
            if (board[col][i] == num) {
                return false;
            }
        }

        //열 비교
        for (int i = 1; i < 10; i++) {
            if (board[i][row] == num) {
                return false;
            }
        }

        //사각형 비교
        int startX = ((row - 1) / 3) * 3 + 1;
        int startY = ((col - 1) / 3) * 3 + 1;

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

}
