package twopointer.boj11728;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[M];

        int aPointer = 0;
        int bPointer = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int resultCount = 0;
        StringBuilder sb = new StringBuilder();

        while (resultCount < (A.length + B.length)) {
            if (A.length == aPointer) {
                resultCount++;
                sb.append(B[bPointer]).append(" ");
                bPointer++;
                continue;
            }
            else if (B.length == bPointer) {
                resultCount++;
                sb.append(A[aPointer]).append(" ");
                aPointer++;
                continue;
            }

            if (A[aPointer] < B[bPointer]) {
                resultCount++;
                sb.append(A[aPointer]).append(" ");
                aPointer++;
            } else {
                resultCount++;
                sb.append(B[bPointer]).append(" ");
                bPointer++;
            }
        }

        System.out.println(sb);



    }
}
