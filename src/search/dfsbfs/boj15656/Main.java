package search.dfsbfs.boj15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr; //임시배열
    static int[] original; //초기 값 받는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        original = new int[N];

        for (int i = 0; i < N; i++) {
            original[i] = sc.nextInt();
        }
        Arrays.sort(original);

        dfs(N, M, 0);
        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth) {
        if (M == depth) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            arr[depth] = original[i];
            dfs(N, M, depth + 1);

        }
    }
}
