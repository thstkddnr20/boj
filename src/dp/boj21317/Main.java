package dp.boj21317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static int[][] arr;

    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2]; //0번에 small, 1번에 big

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        dfs(0, 1, false); //돌 1번부터 시작하므로 to = 1
        System.out.println(result);

    }

    static void dfs(int sum, int to, boolean flag) {
        if (to == N) {
            result = Math.min(result, sum);
            return;
        }

        if (to > N) {
            return;
        }

        //small jump
        dfs(sum + arr[to][0], to + 1, flag);
        //big jump
        dfs(sum + arr[to][1], to + 2, flag);

        if (!flag) {
            dfs(sum + K, to + 3, true);
        }
    }
}

