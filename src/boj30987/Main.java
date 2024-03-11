package boj30987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" "); // 2
        String[] two = br.readLine().split(" "); // 5
        int[] made = new int[3];

        made[0] = Integer.parseInt(two[0]) / 3;
        made[1] = (Integer.parseInt(two[1]) - Integer.parseInt(two[3])) / 2;
        made[2] = Integer.parseInt(two[2]) - Integer.parseInt(two[4]);

        int[] method1 = method(made, Integer.parseInt(one[1]));
        int[] method2 = method(made, Integer.parseInt(one[0]));

        int first = method1[0] - method2[0];
        int second = method1[1] - method2[1];
        int third = method1[2] - method2[2];

        System.out.println(first + second + third);

    }

    private static int[] method(int[] x, int y){
        int first = x[0] * (int) pow(y, 3);
        int second = x[1] * (int) pow(y, 2);
        int third = x[2] * y;
        return new int[]{first, second, third};
    }
}
