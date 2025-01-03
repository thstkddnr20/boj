package dp.boj14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 3;
        dp[7] = 2;
        dp[8] = 4;

        for (int i = 9; i < 100001; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
        }

        System.out.println(dp[num]);
    }
}
