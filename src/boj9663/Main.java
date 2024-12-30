package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] board; //체스판
    static boolean[][] visited; //체스판에 말을 놓을 수 있는가
    static boolean[][] prevVisited; //전 재귀에서 막힌 곳
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];
        prevVisited = new boolean[N][N];

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
                if (!visited[i][j]) { //말을 놓을 수 있다면
                    visited[i][j] = true; //말을 놓고
                    prevVisited[i][j] = true;

                    //말이 이동가능한 방향을 모두 막는다
                    //상하좌우
                    for (int k = 0; k < N; k++) {
                        if (!visited[k][j]) {
                            visited[k][j] = true;
                            prevVisited[k][j] = true;
                        }
                        if (!visited[i][k]) {
                            visited[i][k] = true;
                            prevVisited[i][k] = true;
                        }
                    }
                    //대각선
                    diagonal(i, j);

                    //막은 후 number을 증가시켜 재귀
                    find(number + 1);

                    //막은 부분을 다시 풀어놓는다 -> 이 부분에서 문제 발생 그 전에 건드린 보드판만 지워야 하는데 다른것도 지워짐
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            if (prevVisited[k][l]) {
                                visited[k][l] = false;
                                prevVisited[k][l] = false;
                            }
                        }
                    }

                }
            }
        }

    }

    private static void diagonal(int i, int j) {
        int currentX = i;
        int currentY = j;
        while (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
            if (!visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                prevVisited[currentX][currentY] = true;
            }
            currentX = currentX - 1;
            currentY= currentY + 1;
        }

        //우상
        currentX = i;
        currentY = j;
        while (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
            if (!visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                prevVisited[currentX][currentY] = true;
            }
            currentX = currentX + 1;
            currentY= currentY + 1;
        }

        //좌하
        currentX = i;
        currentY = j;
        while (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
            if (!visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                prevVisited[currentX][currentY] = true;
            }
            currentX = currentX - 1;
            currentY= currentY - 1;
        }

        //우하
        currentX = i;
        currentY = j;
        while (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
            if (!visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                prevVisited[currentX][currentY] = true;
            }
            currentX = currentX + 1;
            currentY= currentY - 1;
        }
    }
}
