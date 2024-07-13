package boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = (Integer.parseInt(br.readLine()));
        }

        Arrays.sort(array);

        // System.out.println으로 계속 출력하는것은 느리다 -> StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i + "\n");
        }
        System.out.println(sb);

    }


}
