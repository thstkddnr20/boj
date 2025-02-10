package dp.boj12865;

import java.util.Scanner;

public class TimeOutAnswer {

    static int N;
    static int K;

    static int[][] dp;
    static boolean[] visited;

    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dp = new int[N][2];
        visited = new boolean[N];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int wei = sc.nextInt();
            min = Math.min(min, wei);
            dp[i - 1][0] = wei;
            dp[i - 1][1] = sc.nextInt();
        }


        for (int i = 0; i < N; i++) {
            find(i, dp[i][0], dp[i][1]);
        }

        System.out.println(max);

    }

    static void find(int depth, int wei, int val) {
        if (wei > K) {
            return;
        }

        for (int i = depth; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                max = Math.max(max, val);
                if (i + 1 < N) {
                    find(i + 1, wei + dp[i + 1][0], val + dp[i + 1][1]);
                }
                visited[i] = false;
            }
        }
    }

}
