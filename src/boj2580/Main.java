package boj2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        if (count == 81) {
            //종료
        }
        if (!checkError(count - 1)) { //count - 1의 오류 파악
            return;
        }

        //count를 9로 나눠 몫을 열, 나머지를 행으로 사용
        if (board[count / 9][count % 9] != 0) {
            //해당 board가 0이 아닌경우 count + 1 해서 재귀
            recursion(count + 1);
        }
        else {
            //0인 경우

            //행과 열과 사각형으로 놓을 수 있는 숫자 파악?

            //우선순위 1 - 행 열 사각 검사했는데 놓을 수 있는 숫자가 1개가 나온게 있다 -> 그게 정답
            //우선순위 2 - 놓을 수 있는 숫자가 예를들어 행에 1, 2 열에 2, 4 사각에 2, 5가 나왔다 -> 중복되는 2가 정답
            //우선순위 3 - 놓을 수 있는 숫자가 2,4 2,4 2,4 로 여러 값이 중복 -> 값을 저장시켜놓고 2를 넣는다, 아니라면 돌아와서 4를 넣는다

        }



        /**
         * count 파라미터는 재귀 값 증가, 되돌리기 역할
         */


    }

    static boolean checkError(int count) { //count로 해당 열, 행, 사각형의 오류 확인
        if (count == 0) {
            return true;
        }
    }

    static int[] checkRow(int y) { //y는 열로 행 검사

    }

    static int[] checkColumn(int x) {

    }

    static int[] checkSquare(int count) {

    }
}
