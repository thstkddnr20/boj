package twopointer.boj1806;

import java.util.Scanner;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;

        //left = 0, right = 0으로 시작,
        //left = N - 1 일때 종료
        int currentSum = arr[0];

        while (left != N - 1) {

            //합이 작으면 right++;

            //합이 넘어가면 left++;
            if (currentSum < S) {
                if (right == N - 1) { //right가 우측끝에 도달한 경우 왼쪽만 조절할 수 있다
                    currentSum -= arr[left];
                    left++;
                    continue;
                }
                right++;
                currentSum += arr[right];
            }
            else {
                result = Math.min(right - left + 1, result);
                currentSum -= arr[left];
                left++;
            }

        }

        if (arr[N - 1] >= S) { //마지막 요소 검사
            result = 1;
        }

        if (result == Integer.MAX_VALUE) { // 부분합 없는 경우
            result = 0;
        }

        System.out.println(result);
    }
}
