package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간초과 풀이
 * 해결법 : 2차원 배열을 1차원배열로 줄여야한다
 * 행과 열을 모두 사용하는 2차원 배열과 달리 어차피 한 행에는 퀸이 하나밖에 들어가지 못한다는 점을 이용하여
 * 1차원배열의 index를 행으로, 그 index에 해당하는 요소를 열로 사용하면 해결된다
 *
 * 또한 대각에 퀸이 있는지 검사하기 위하여 대각과의 x거리와 y거리가 같다는 특징을 이용한다
 */
public class TimeoutAnswer {
    static int N;
    static boolean[][] placed; //체스판에 말을 놓을 수 있는가(체스판을 되돌릴때 중복되는 부분이 있어 문제가 됨) -> Queen이 놓여진 자리로 변경
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        placed = new boolean[N][N];

        find(0, null, null);
        System.out.println(result);
    }

    static void find(int number, Integer x, Integer y) { //number은 체스말을 얼마나 넣었는지
        if (number == N) {
            result++;
            return;
        }


        //이 2중 for문이 문제인듯
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (possible(i, j, x, y)) { //queen이 놓여져있지 않고, 다른 queen에 의해 잡히지 않는 곳이라면
                    placed[i][j] = true; //queen을 놓고

                    //queen을 놓고 number을 증가시켜 재귀, 마지막 놓은 queen의 위치를 파라미터로 전달
                    find(number + 1, i, j);

                    placed[i][j] = false; //놓은 queen을 되돌린다
                }
            }
        }

    }

    static boolean possible(int x, int y, Integer queenX, Integer queenY) {
        //queen이 놓여진 체스판 placed와 x(행), y(열)를 비교하여 말을 놓을 수 있는 자리인지 파악

        //마지막으로 queen이 놓여진 부분보다 x,y가 커야함
//        Integer queenX = null;
//        Integer queenY = null;
//
//        loop1:
//        for (int i = N - 1; i >= 0; i--) {
//            for (int j = N - 1; j >= 0; j--) {
//                if (placed[i][j]) {
//                    queenX = i;
//                    queenY = j;
//                    break loop1;
//                }
//            }
//        }

        if (queenX != null) {
            if (x <= queenX) {
                return false;
            }
            else {
                if (y == queenY) {
                    return false;
                }
            }
//                if (y < queenY) {
//                    return false;
//                }
        }

        //queen과 같은 x, y면 안됨
        //queen과 대각에 놓여있으면 안됨
        //x, y는 마지막 놓인 queen보다 큰 값이므로 대각의 좌상, 우상만 확인하면된다
        for (int i = 0; i < N; i++) {
//            if (placed[x][i]) {
//                return false;
//            }
            if (placed[i][y]) {
                return false;
            }

            if (x - i >= 0) {
                //좌상
                if (y - i >= 0) {
                    if (placed[x - i][y - i]) {
                        return false;
                    }
                }
                //우상
                if (y + i < N) {
                    if (placed[x - i][y + i]) {
                        return false;
                    }
                }
            }
//            if (x - i >= 0 && y - i >= 0) {
//                if (placed[x - i][y - i]) {
//                    return false;
//                }
//            }
//            if (x - i >= 0 && y + i < N) {
//                if (placed[x - i][y + i]) {
//                    return false;
//                }
//            }
//            //좌하
//            if (x + i < N && y - i >= 0) {
//                if (placed[x + i][y - i]) {
//                    return false;
//                }
//            }
//            //우하
//            if (x + i < N && y + i < N) {
//                if (placed[x + i][y + i]) {
//                    return false;
//                }
//            }
        }

        return true;

    }
}
