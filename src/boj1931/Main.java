package boj1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] use = new int[num][2];

        for (int i = 0; i < num; i++) {
            use[i][0] = sc.nextInt();
            use[i][1] = sc.nextInt();
        }

        Arrays.sort(use, (a, b) -> {
            //종료 시간이 같을 경우 시작시간이 빠른 순으로 정렬
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int end = 0;
        for (int i = 0; i < use.length; i++) {
            if (end <= use[i][0]) {
                count++;
                end = use[i][1];
            }
        }

        System.out.println(count);
    }
}
