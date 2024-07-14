package boj1003.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 0.25초 시간제한 초과항 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            fibonacci(num);
            sb.append(result0).append(' ').append(result1).append("\n");
            result0 = 0;
            result1 = 0;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(sb);
        System.out.println(endTime - startTime);
    }

    static StringBuilder sb = new StringBuilder();
    static int result0 = 0;
    static int result1 = 0;

    static void fibonacci(int n) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            result0++;
        } else if (n == 1) {
            result1++;
        } else {
            fibonacci(n - 1);
            fibonacci(n - 2);
        }
    }
}
