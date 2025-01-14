package boj1339;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[27]; //알파벳 총 개수 26

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            //s의 길이 파악
            int length = s.length();
            int start = (int) Math.pow(10, length - 1);

            for (int j = 0; j < s.length(); j++) {
                int charAt = s.charAt(j); //아스키 A=65 ~ J=74
                num[charAt - 64] += start;
                start = start / 10;
            }
        }

        int result = 0;
        //num 배열에서 큰 값부터 꺼내서 9~0까지 곱한 후 result에 더한다
        Arrays.sort(num);
        int number = 9;
        for (int i = 26; i > 0; i--) {
            result += num[i] * number;
            number--;
        }
        System.out.println(result);


    }


}
