package boj2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] board = new int[10][10];
    static int[] fullRange = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(1);
    }

    static void recursion(int count) {
        /**
         * 탈출 조건
         * board에서 행, 열, 사각형에서 겹치는 숫자가 있을 때
         *
         * 탈출 후
         * 놨던 숫자를 다시 0으로 되돌린다
         */
        if (count == 82) {
            //종료
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
        if (errorExist(count - 1)) { //count - 1의 오류 파악
            return;
        }

        //count를 9로 나눠 몫을 열, 나머지를 행으로 사용
        int column = count / 9 + 1;
        int row = count % 9;
        if (count % 9 == 0) {
            row = 9;
            column = column - 1;
        }

        if (board[column][row] != 0) {
            //해당 board가 0이 아닌경우 count + 1 해서 재귀
            recursion(count + 1);
        }
        else {
            //0인 경우

            //행과 열과 사각형으로 놓을 수 있는 숫자 파악?

            //우선순위 1 - 행 열 사각 검사했는데 놓을 수 있는 숫자가 1개가 나온게 있다 -> 그게 정답
            //우선순위 2 - 놓을 수 있는 숫자가 예를들어 행에 1, 2 열에 2, 4 사각에 2, 5가 나왔다 -> 중복되는 2가 정답
            //우선순위 3 - 놓을 수 있는 숫자가 2,4 2,4 2,4 로 여러 값이 중복 -> 값을 저장시켜놓고 2를 넣는다, 아니라면 돌아와서 4를 넣는다
            Set<Integer> possible = findPossible(row, column);
            for (Integer integer : possible) {
                board[column][row] = integer;
                recursion(count + 1);
                board[column][row] = 0;
            }

        }



        /**
         * count 파라미터는 재귀 값 증가, 되돌리기 역할
         */


    }

    static boolean errorExist(int count) { //count로 해당 열, 행, 사각형의 오류 확인
        if (count == 0) {
            return false;
        }
        else {
            int x = count % 9;
            int y = count / 9 + 1;
            if (count % 9 == 0) {
                x = 9;
                y = y - 1;
            }

            //열, 행 검사
            Set<Integer> row = new HashSet<>();
            Set<Integer> column = new HashSet<>();
            Set<Integer> square = new HashSet<>();
            for (int i = 1; i < 10; i++) {
                if (board[y][i] != 0) {
                    if (!row.contains(board[y][i])) {
                        row.add(board[y][i]);
                    }
                    else {
                        return true;
                    }
                }
                if (board[i][x] != 0) {
                    if (!column.contains(board[i][x])) {
                        column.add(board[i][x]);
                    }
                    else {
                        return true;
                    }
                }
            }

            //사각형 검사
            int[] xy = findSquareStartXY(x, y);
            for (int j = xy[1]; j < xy[1] + 3; j++) {
                for (int k = xy[0]; k < xy[0] + 3; k++) {
                    if (board[j][k] != 0) {
                        if (!square.contains(board[j][k])) {
                            square.add(board[j][k]);
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    static Set<Integer> findPossible(int x, int y) {
        Set<Integer> set = new HashSet<>();

        //열, 행 검사
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        List<Integer> square = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            row.add(board[y][i]);
            column.add(board[i][x]);
        }

        //사각형 검사
        int[] xy = findSquareStartXY(x, y);
        int startX = xy[0];
        int startY = xy[1];
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                square.add(board[i][j]);
            }
        }

        for (int i : fullRange) {
            if (!row.contains(i)) {
                set.add(i);
            }
            if (!column.contains(i)) {
                set.add(i);
            }
            if (!square.contains(i)) {
                set.add(i);
            }
        }
        return set;

    }

    static int[] findSquareStartXY(int x, int y) {
        int xStart = ((x - 1) / 3) * 3 + 1;
        int yStart = ((y - 1) / 3) * 3 + 1;

        return new int[] { xStart, yStart };
    }

}
