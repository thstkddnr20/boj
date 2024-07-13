package boj1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for (int i = 0; i < string.length(); i++) {
            int integer = string.charAt(i) - 65;
            arr[integer] += 1;
        }

        int max = 0;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                result = (char) (i + 65);
            } else if (max == arr[i]) {
                result = '?';
            }
        }


        System.out.println(result);
    }
}
