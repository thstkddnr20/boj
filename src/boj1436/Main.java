package boj1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int disaster = 666;

        int n = 0;

        while (true) {
            if (String.valueOf(disaster).contains("666")) {
                n++;
                if (n == num) {
                    break;
                }
            }
            disaster++;
        }

        System.out.println(disaster);
    }
}
