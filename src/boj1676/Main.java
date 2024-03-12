package boj1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BigInteger ans = BigInteger.ONE;

        for (int i = num; i > 0; i--) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        int result = 0;

        String string = ans.toString();
        for (int j = string.length() - 1; j > 0; j--) {
            char c = string.charAt(j);
            if (c == '0') {
                result = result + 1;
            } else {
                break;
            }
        }

        System.out.println(result);

    }
}
