package boj2668;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer> result = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int i1 = sc.nextInt();
            arr[i] = i1;
        }

        for (int i = 1; i <= N; i++) {
            recursion(0, i, i);
        }
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    //index 1부터 시작해서 깊이 우선 탐색하면될듯?
    static void recursion(int depth, int start, int index) {
        if (depth != 0) {
            if (start == index) {
                result.add(index);
            }
        }

        if (!visited[index]) {
            visited[index] = true;
            recursion(depth + 1, start, arr[index]);
            visited[index] = false;
        }

    }

}
