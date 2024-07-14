package boj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairCount = Integer.parseInt(br.readLine());

        dp = new int[stairCount + 1];
        score = new int[stairCount + 1];

        for (int i = 1; i < stairCount + 1; i++) {
            int stairScore = Integer.parseInt(br.readLine());
            score[i] = stairScore;
        }

        dp[1] = score[1];

        if (stairCount >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i < stairCount + 1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + score[i-1]) + score[i];
        }

        System.out.println(dp[stairCount]);

    }
}
