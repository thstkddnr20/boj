package twopointer.boj2470;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] ansArr = new int[2];
    static int smallest = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int plus = arr[left] + arr[right];
            //plus가 음수라면 left를 오른쪽으로 땡겨봐서 확인해볼 필요가 있고
            //양수라면 right를 왼쪽으로 땡겨봐서 확인해볼 필요가 있다

            if (Math.abs(plus) < smallest) { //음수값일 수 있으므로 절댓값 적용
                ansArr[0] = arr[left];
                ansArr[1] = arr[right];
                smallest = Math.abs(plus);
            }

            if (plus < 0) {
                left++;
            }
            else {
                right--;
            }

        }

        System.out.println(ansArr[0] + " " + ansArr[1]);


    }
}
