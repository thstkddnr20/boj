package search.dfsbfs.boj1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visited = new boolean[10000001];
    static int min;
    static int finish;

    public static void main(String[] args) {
        //그래프 탐색으로 depth를 찾아야함
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        finish = sc.nextInt();
        if (N == finish) {
            System.out.println(0);
            System.exit(0);
        }

        bfs(N);
        System.out.println(min);
    }

    static void bfs(int start) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                visited[poll] = true;

                if (poll.equals(finish)) {
                    min = depth;
                    queue.clear();
                    break;
                }

                int[] searchList = new int[]{poll - 1, poll + 1, poll * 2};
                for (int element : searchList) {
                    if (element >= 0 && !visited[element] && element < 200000) {
                        queue.add(element);
                    }
                }
            }

            depth++;
        }
    }
}
