package boj1182;

import java.util.Scanner;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
        }

        recursion(0, 0);

        if (S == 0) {
            result--;
        }

        System.out.println(result);
    }

    static void recursion(int depth, int total) { //탐색 깊이, total 전체(S랑 비교할 값)
        if (depth == N) {
            if (total == S) {
                result++;
            }
            return;
        }

        recursion(depth + 1, total + arr[depth]); // + arr[depth]해서 내려가기
        recursion(depth + 1, total); //그냥 내려가기

    }
}
