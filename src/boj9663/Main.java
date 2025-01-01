package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2중 for문으로 모든 경우 탐색할 때의 문제점 : 체스판이 중복될 수 있다 (기존에 만든 체스판과 같은 결과가 나올 수 있음) -> 정답보다 큰 값이 나옴
//해결방법 : for문을 1개만 써서 행 단위로 검사 진행
public class Main {
    static int N;
    static int[][] board; //체스판
    static boolean[][] placed; //체스판에 말을 놓을 수 있는가(체스판을 되돌릴때 중복되는 부분이 있어 문제가 됨) -> Queen이 놓여진 자리로 변경
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        placed = new boolean[N][N];

        find(0);
        System.out.println(result);
    }

    static void find(int number) { //number은 체스말을 얼마나 넣었는지
        if (number == N) {
            result++;
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (possible(i, j, number)) { //queen이 놓여져있지 않고, 다른 queen에 의해 잡히지 않는 곳이라면
                    placed[i][j] = true; //queen을 놓고

                    //queen을 놓고 number을 증가시켜 재귀
                    find(number + 1);

                    placed[i][j] = false; //놓은 queen을 되돌린다
                }
            }
        }

    }

    static boolean possible(int x, int y, int queenNum) {
        //queen이 놓여진 체스판 placed와 x, y를 비교하여 말을 놓을 수 있는 자리인지 파악
        if (queenNum == 0) { //놓여진 queen이 없다면
            return true;
        }


        for (int i = 0; i < N; i++) {
            if (placed[x][i]) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (placed[i][y]) {
                return false;
            }
        }


        //대각
        for (int i = 0; i < N; i++) {
            if (x - i >= 0 && y - i >= 0) {
                if (placed[x - i][y - i]) {
                    return false;
                }
            }
            if (y + i < N && x - i >= 0) {
                if (placed[x - i][y + i]) {
                    return false;
                }
            }
            if (x + i < N && y - i >= 0) {
                if (placed[x + i][y - i]) {
                    return false;
                }
            }
            if (x + i < N && y + i < N) {
                if (placed[x + i][y + i]) {
                    return false;
                }
            }

        }


        return true;

        
        //queen과 같은 x, y면 안됨
        //queen과 대각에 놓여있으면 안됨

    }
}
