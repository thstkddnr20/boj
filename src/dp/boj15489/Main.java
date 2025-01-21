package dp.boj15489;

import java.util.Scanner;

public class Main {
    static int[][] arr = new int[31][];
    static int result;
    public static void main(String[] args) {

        for (int i = 0; i < 31; i++) {
            arr[i] = new int[i];
        }

        //첫번째 두번째 세번째
        arr[1][0] = arr[2][0] = arr[2][1] = 1;

        for (int i = 3; i < 31; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();

        int counter = 1;
        //arr[R][C-1] 부터 W까지
        for (int i = R; i < R + W; i++) {
            for (int j = C - 1; j < C - 1 + counter; j++) {
                result += arr[i][j];
            }
            counter++;
        }

        System.out.println(result);
    }
}
