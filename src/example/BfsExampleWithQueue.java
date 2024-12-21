package example;

import java.util.*;

public class BfsExampleWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정점의 개수
        int M = sc.nextInt(); //정점을 잇는 간선의 개수

        int V = sc.nextInt(); //탐색을 시작하는 정점의 번호

        boolean[] visited = new boolean[N + 1]; // 개수와 인덱스를 맞추기 위해 +1을 함

        ArrayList<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            nodes[i1].add(i2);
            nodes[i2].add(i1);
        }

        for (int i = 1; i < N + 1; i++) {
            nodes[i].sort(Comparator.naturalOrder()); //오름차순 정렬
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (visited[num]) {
                continue;
            }
            else {
                sb.append(num).append(" ");
                visited[num] = true;
            }

            ArrayList<Integer> adjacent = nodes[num];
            if (!adjacent.isEmpty()) {
                for (Integer integer : adjacent) {
                    if (!visited[integer]) {
                        queue.add(integer);
                    }
                }
            }
        }

        System.out.println(sb);

    }
}
