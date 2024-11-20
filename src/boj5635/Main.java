package boj5635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer low = null;
        String lowGuy = null;
        Integer high = null;
        String highGuy = null;

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if (split[2].length() < 2) {
                split[2] = "0" + split[2];
            }
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }

            int birth = Integer.parseInt(split[3] + split[2] + split[1]);

            if (low == null) {
                low = birth;
                lowGuy = split[0];
                high = birth;
                highGuy = split[0];
                continue;
            }

            if (low < birth) {
                low = birth;
                lowGuy = split[0];
            }
            if (high > birth) {
                high = birth;
                highGuy = split[0];
            }
        }

        System.out.println(lowGuy);
        System.out.println(highGuy);

    }
}
