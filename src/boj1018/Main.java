package boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] chess = new String[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int min = 1000;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, getWrongPoint(i, j, chess));
            }
        }

        System.out.println(min);
    }

    private static int getWrongPoint(int nStart, int mStart, String[][] chess) {

        int first = findWrong(nStart, mStart, chess, "B");
        int second = findWrong(nStart, mStart, chess, "W");
        return Math.min(first, second);
    }

    private static int findWrong(int nStart, int mStart, String[][] chess, String start) {
        int wrongPoint = 0;
        for (int i = nStart; i < nStart + 8; i++) {
            for (int j = mStart; j < mStart + 8; j++) {
                String current = chess[i][j];

                if (i % 2 == 0 && j % 2 == 0) {
                    if (!current.equals(start)) {
                        wrongPoint++;
                    }
                } else if (i % 2 != 0 && j % 2 != 0) {
                    if (!current.equals(start)) {
                        wrongPoint++;
                    }
                } else {
                    if (current.equals(start)) {
                        wrongPoint++;
                    }
                }

            }
        }
        return wrongPoint;
    }
}
