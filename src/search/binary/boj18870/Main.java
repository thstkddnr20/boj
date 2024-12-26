package search.binary.boj18870;

import java.util.*;

public class Main {
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            int i1 = sc.nextInt();
            arr[i] = i1;
            set.add(i1);
        }

        list = new ArrayList<>(set);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(binarySearch(i)).append(" ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int find) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            Integer i = list.get(mid);
            if (i.equals(find)) {
                return mid;
            } else if (i > find) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
