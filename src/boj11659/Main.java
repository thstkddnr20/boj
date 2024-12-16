package boj11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] ints = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            ints[i] = sc.nextInt() + ints[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < M + 1; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            sb.append(ints[s] - ints[f - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
