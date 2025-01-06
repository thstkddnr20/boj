package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int N;
    static int answer = 0;

    public static boolean check(int curRow) {
        for (int i = 0; i < curRow; i++) {
            // 같은 열에 있는지 확인
            if (arr[curRow] == arr[i]) {
                return false;
            }
            // 대각선 위치에 있는지 확인
            // 두 칸이 각각 (x1, y1), (x2, y2) 좌표를 가질 때
            // |x1-x2| == |y1-y2| 이면 대각선에 있는 것이므로 false 반환
            else if(Math.abs(curRow-i) == Math.abs(arr[curRow]-arr[i])) {
                return false;
            }
        }
        return true;
    }
    // arr = [2, 0, 1, 4] -> arr : (0,2) (1,0) (2,1) (3,4)

    public static void backtrack(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i; // depth 가 현재 검색하고있는 행
            // 현재 검색하고 있는 행의 퀸의 자리 (열번호)를 담고 있음.
            if (check(depth)) {
                backtrack(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        arr = new int[N]; //어차피 각 행에는 queen이 1개밖에 들어가지 않으므로 index를 행으로, index에 해당하는 숫자를 열로 사용한다

        backtrack(0);
        System.out.println(answer);
    }
}

