package twopointer.boj1450;

import java.util.Scanner;

public class TimeoutAnswer {
    static int N;
    static int C;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        arr = new int[N];

        if (C == 0) {
            System.out.println(0);
            System.exit(0);
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int i1 = sc.nextInt();
            sum += i1;
            arr[i] = i1;
        }

        if (N != 1 && sum <= C) {
            result = (int) Math.pow(2, N);
        }
        else {
            dfs(0, 0);
        }

        System.out.println(result);


    }

    static void dfs(int depth, long wei) {
        if (wei > C) {
            return;
        }
        if (depth == N) {
            result++;
            return;
        }

        dfs(depth + 1, wei + arr[depth]);
        dfs(depth + 1, wei);
    }
}
