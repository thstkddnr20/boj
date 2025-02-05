package dp.boj2294;

import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new long[K + 1];
        for (int i = 1; i <= K; i++){
            dp[i] = Integer.MAX_VALUE;
        }


        /**
         * 예제 3 5
         *     1
         *     2
         *     3
         */
        //s -> [0, M, M, M, M, M]
        //1 -> [0, 1, 2, 3, 4, 5]
        //2 -> [0, 1, 1, 2, 2, 3]
        //3 -> [0, 1, 1, 1, 2, 2]
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            for (int j = num; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }

        if (dp[K] == Integer.MAX_VALUE) {
            dp[K] = -1;
        }

        System.out.println(dp[K]);

    }
}
