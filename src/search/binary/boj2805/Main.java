package search.binary.boj2805;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tree = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        System.out.println(binarySearch(tree, M));
    }

    //start와 end의 중간인 mid를 구한다

    //mid값에서 나무를 잘랐을 때
    //상황1 나무가 M과 같다, 상황2 나무가 M보다 크다, 상황3 나무가 M보다 작다
    //상황1 값 반복문 종료, 값 리턴
    //상황2 나무가 M보다 크다 end 값 조정
    //상황3 M이 나무보다 크다 start값 조정
    public static int binarySearch(int[] tree, int M) {
        int start = 0;
        int end = tree[tree.length - 1];

        //while문
        while (start < end) {
            int mid = (start + end) / 2;

            long result = cut(tree, mid);

            if (result == M) {
                return mid;
            } else if (result > M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end - 1;
    }

    public static long cut(int[] tree, int mid) {
        long result = 0;
        for (Integer treeHeight : tree) {
            if (treeHeight - mid > 0) {
                result += (treeHeight - mid);
            }
        }
        return result;
    }
}
