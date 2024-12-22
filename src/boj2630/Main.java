package boj2630;

import java.util.Scanner;

public class Main {
    public static int blue = 0;
    public static int white = 0;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        search(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);


    }

    public static void search(int N, int x, int y) {
        boolean w = true;
        boolean b = true;

        for (int i = x; i < x + N; i++) { //파란색이 하나라도 나올 시 W는 false, 하얀색이 하나라도 나올 시 B는 false가 된다. 즉 W만 나올경우 B는 true이다
            for (int j = y; j < y + N; j++) {
                int i1 = arr[i][j];
                if (i1 == 1) {
                    w = false;
                }
                else {
                    b = false;
                }
            }
        }

        if (b) {
            blue++;
            return;
        }

        if (w) {
            white++;
            return;
        }

        search(N / 2, x, y); // 왼쪽 위
        search(N / 2, x + N / 2, y); //오른쪽 위
        search(N / 2, x, y + N / 2); //왼쪽 아래
        search(N / 2, x + N / 2, y + N / 2); //오른쪽 아래
    }
}
