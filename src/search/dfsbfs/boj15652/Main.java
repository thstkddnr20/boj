package search.dfsbfs.boj15652;

import java.util.Scanner;

public class Main {
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr; //탐색한 수를 임시 저장할 곳

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dfs(N, M, 0);
        System.out.println(sb);

    }

    static void dfs(int N, int M, int depth) {
        //탈출 조건 M과 현재 depth가 같은 경우, 그 전까지는 탐색
        if (M == depth) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth != 0) {
                if (arr[depth - 1] > i + 1) {
                    continue;
                }
            }
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }
}
