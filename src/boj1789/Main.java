package boj1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long num = 0;
        long count = 0;

        while (true) {
            if (num > s) {
                break;
            }
            count++;
            num += count;
        }

        count = count - 1;
        System.out.println(count);
    }
}
