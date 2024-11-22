package dp.boj9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] ints = new int[46][2];

        ints[1][0] = 0;
        ints[1][1] = 1;

        ints[2][0] = 1;
        ints[2][1] = 1;

        for (int i = 3; i < 46; i++) {
            ints[i][0] = ints[i - 1][0] + ints[i - 2][0];
            ints[i][1] = ints[i - 1][1] + ints[i - 2][1];
        }

        System.out.println(ints[n][0] + " " + ints[n][1]);
    }
}
