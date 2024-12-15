package boj1074;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int position = findPosition(x, y);
        int start = (position - 1) * 4;

        if (x % 2 == 0 && y % 2 == 0) {
            System.out.println(start);
        } else if (x % 2 == 0) {
            System.out.println(start + 1);
        } else if (y % 2 == 0) {
            System.out.println(start + 2);
        } else {
            System.out.println(start + 3);
        }


    }


    public static int findPosition(int x, int y) { //사분면 찾기
        x = x + 1;
        if (x % 2 != 0) {
            x = x + 1;
        }
        x = x / 2;

        y = y + 1;
        if (y % 2 != 0) {
            y = y + 1;
        }
        y = y / 2;

        return x * y;

    }
}
