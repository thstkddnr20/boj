package twopointer.boj1450;

import java.util.*;

public class Main {
    static int N;
    static int C;
    static int[] arr;
    static int[] left;
    static int[] right;

    static List<Long> leftSubSum = new ArrayList<>();
    static List<Long> rightSubSum = new ArrayList<>();

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) { //meet in the middle
            arr[i] = sc.nextInt();
        }

        int mid = N / 2;
        left = new int[mid];
        right = new int[N - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, N - mid);

        getSubSum(0, 0, left, leftSubSum);
        getSubSum(0, 0, right, rightSubSum);

        Collections.sort(rightSubSum); //이진탐색을 위해 sort

        for (Long integer : leftSubSum) {
            result += getResult(integer, rightSubSum);
        }

        System.out.println(result);
    }

    static void getSubSum(int depth, long sum, int[] arr, List<Long> result) { //전위순회트리
        if (depth == arr.length) {
            result.add(sum);
            return;
        }

        getSubSum(depth + 1, sum + arr[depth], arr, result);
        getSubSum(depth + 1, sum, arr, result);
    }

    static int getResult(long i, List<Long> list) { //이진탐색 조합 계산
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            long sum = list.get(mid) + i;
            if (sum > C) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
