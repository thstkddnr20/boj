package dp.boj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BigInteger[] arr = new BigInteger[31];
        arr[1] = BigInteger.ONE;

        for (int i = 2; i < 31; i++) {
            arr[i] = arr[i - 1].multiply(BigInteger.valueOf(i));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            if (M - N == 0) {
                System.out.println(1);
                continue;
            }
            System.out.println(arr[M].divide(arr[M-N]).divide(arr[N]));
        }
    }
}
