package search.binary.boj1654;

import java.util.Scanner;

public class Main {
    static int max = 0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        arr = new int[K];

        long total = 0; //총 길이
        for (int i = 0; i < K; i++) {
            int line = sc.nextInt();
            arr[i] = line;
            total += line;
        }

        max = (int) (total / N);

        System.out.println(binarySearch(N));
    }

    public static int binarySearch(int N) {
        long start = 1;
        long end = max;
        int candidate = 0;

        while (start <= end) {

            long mid = (start + end) / 2;
            int intMid = (int) mid;
            //mid를 이용하여 cut 진행
            int count = 0; //잘라진 랜선의 수
            for (int i = 0; i < arr.length; i++) {
                count += cut(arr[i], intMid);
            }

            if (count >= N) {
                candidate = intMid;
                if (start == end) {
                    return candidate;
                }
                start = intMid + 1;
            } else {
                if (start == end) {
                    return candidate;
                }
                end = intMid;
            }


        }



        return candidate;
    }

    public static int cut(int line, int length) {
        if (length == 0) {
            return line;
        }
        return line / length;
    }
}
