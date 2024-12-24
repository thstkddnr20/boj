package boj1002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] arr = new int[6]; //x1, y1, result1, x2, y2, result2
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                arr[j] = sc.nextInt();
            }

            int abs1 = Math.abs(arr[0] - arr[3]);
            int abs2 = Math.abs(arr[1] - arr[4]);
            double d = Math.sqrt(abs1 * abs1 + abs2 * abs2);


            int sumR = arr[2] + arr[5];
            if (d > sumR) {
                sb.append(0).append("\n");
            } else if (d == sumR) {
                sb.append(1).append("\n");
            } else {
                if (d == 0) {
                    if (arr[2] == arr[5]) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                }
                else {
                    if (d + Math.min(arr[2], arr[5]) == Math.max(arr[2], arr[5])) {
                        sb.append(1).append("\n");
                    } else if (d + Math.min(arr[2], arr[5]) < Math.max(arr[2], arr[5])) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(2).append("\n");
                    }

                }
            }


        }
        System.out.println(sb);


    }
}
