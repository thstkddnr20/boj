package boj8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int result = 0;
        int prev = 0;

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String ox = br.readLine();
            for (int j = 0; j < ox.length(); j++) {
                if (ox.charAt(j) == 'O') {
                    prev += 1;
                    result += prev;
                } else {
                    prev = 0;
                }
            }
            sb.append(result).append('\n');
            result = 0;
            prev = 0;
        }
        System.out.println(sb);
    }
}
