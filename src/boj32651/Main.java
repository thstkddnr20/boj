package boj32651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if (num > 100000) {
            System.out.println("No");
        } else {
            if (num % 2024 != 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
