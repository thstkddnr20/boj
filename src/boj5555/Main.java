package boj5555;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (ring.contains(s)) {
                    result++;
                    break;
                }
                ring = remake(ring);
            }
            //모든 경우의 수를 확인하기 위해서는 맨 앞 문자를 10번 뒤로 넘기면 된다

        }

        System.out.println(result);
    }

    public static String remake(String raw) {
        String substring = raw.substring(1);
        return substring.concat(raw.substring(0, 1));
    }
}
