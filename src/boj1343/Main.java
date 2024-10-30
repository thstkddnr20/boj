package boj1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            if (c == 'X') {
                count++;
            }
            if (c == '.') {
                if (count == 0) {
                    sb.append(".");
                    continue;
                }
                if (count % 2 == 0) { //count가 짝수라면
                    int i1 = count / 4;
                    if (count % 4 == 0) {
                        sb.append("AAAA".repeat(i1)).append(".");
                        count = 0;
                    } else {
                        sb.append("AAAA".repeat(i1)).append("BB").append(".");
                        count = 0;
                    }
                }
                else { //count가 홀수라면
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        if (count != 0) {
            if (count % 2 == 0) { //count가 짝수라면
                int i1 = count / 4;
                if (count % 4 == 0) {
                    sb.append("AAAA".repeat(i1));
                } else {
                    sb.append("AAAA".repeat(i1)).append("BB");
                }
            }
            else { //count가 홀수라면
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(sb);
    }
}
