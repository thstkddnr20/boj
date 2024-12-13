package boj11068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            boolean palindrome;
            boolean wasPalindrome = false;
            for (int j = 2; j <= 64 ; j++) {
                String s = convertDecimalToBase(num, j);
                palindrome = isPalindrome(s);
                if (palindrome) {
                    wasPalindrome = true;
                    System.out.println(1);
                    break;
                }
            }
            if (!wasPalindrome) {
                System.out.println(0);
            }
        }

    }

    public static String convertDecimalToBase(int decimal, int base) {
        StringBuilder sb = new StringBuilder();

        while (decimal > 0) {
            int temp = decimal % base;

            if (temp >= 10) {
                sb.append((char) (temp - 10 + 'a'));
            } else {
                sb.append(temp);
            }

            decimal = decimal / base;
        }

        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.contentEquals(sb.reverse().toString());
    }
}
