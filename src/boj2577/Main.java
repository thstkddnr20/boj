package boj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int ABC = A * B * C;

        int[] result = new int[10];

        String string = Integer.toString(ABC);
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            result[c-48] += 1;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
