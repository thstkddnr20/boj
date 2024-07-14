package boj15649.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[M];
        visit = new boolean[N];

        recursion(N, M, 0);
        System.out.println(sb);
    }

    public static void recursion(int N, int M, int depth) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i + 1;
                recursion(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
