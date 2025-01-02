package boj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] ints;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ints = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            ints[i][0] = Integer.parseInt(s[0]);
            ints[i][1] = Integer.parseInt(s[1]);
            ints[i][2] = Integer.parseInt(s[2]);
        }

        dp(0, null);
        System.out.println(result);
    }

    static void dp(int depth, Integer excludeIndex) {

        if (depth == 0) {
            //3개의 배열을 다음 배열과 모두 비교
            int small1 = Math.min(ints[depth][0] + ints[depth + 1][1], ints[depth][0] + ints[depth + 1][2]);
            int small2 = Math.min(ints[depth][1] + ints[depth + 1][0], ints[depth][1] + ints[depth + 1][2]);
            int small3 = Math.min(ints[depth][2] + ints[depth + 1][0], ints[depth][2] + ints[depth + 1][1]);

            int smallest = Math.min(Math.min(small1, small2), small3);

            result += smallest;
            //excludeIndex 지정
            int index;
            if (smallest == small1) {
                index = 0;
            }
            if (smallest == small2) {
                index = 1;
            }
            else {
                index = 2;
            }

            dp(depth + 1, index);
        }

        if (depth == N - 1) {
            return;
        }

        //excludeIndex 제외하고 나머지 비교
        int small1 = Math.min(ints[depth + 1][1], ints[depth + 1][2]);
        int small2 = Math.min(ints[depth + 1][0], ints[depth + 1][2]);
        int small3 = Math.min(ints[depth + 1][0], ints[depth + 1][1]);

        int smallest;
        if (excludeIndex == 0) {
            smallest = Math.min(small2, small3);
        } else if (excludeIndex == 1) {
            smallest = Math.min(small1, small3);
        } else {
            smallest = Math.min(small1, small2);
        }

        result += smallest;
        //excludeIndex 지정
        int index;
        if (smallest == small1) {
            index = 0;
        }
        if (smallest == small2) {
            index = 1;
        }
        else {
            index = 2;
        }

        dp(depth + 1, index);


    }
}
