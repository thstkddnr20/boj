package twopointer.boj3273;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int X;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        X = sc.nextInt();

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        //정답일 경우 left++; right--;
        //X보다 클 경우 right--;
        //작을 경우 left++;

        while (left < right) {
            int ans = arr[left] + arr[right];
            if (ans == X) {
                result++;
                left++;
                right--;
            } else if (ans < X) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);
    }
}
