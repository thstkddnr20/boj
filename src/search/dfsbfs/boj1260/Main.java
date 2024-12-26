package search.dfsbfs.boj1260;

import java.util.*;

public class Main {
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
            nodes[i].sort(Comparator.reverseOrder()); //dfs 역순 정렬하고 시작
        }
        System.out.println(dfs(nodes, Arrays.copyOf(visited, visited.length), V));
        for (int i = 1; i < N + 1; i++) {
            nodes[i].sort(Comparator.naturalOrder()); //bfs 오름차순 정렬하고 시작
        }
        System.out.println(bfs(nodes, Arrays.copyOf(visited, visited.length), V));

    }

    static String dfs(ArrayList<Integer>[] nodes, boolean[] visited, int V) {
        Stack<Integer> stack = new Stack<>();

        //시작 정점을 stack에 넣고 방문 처리
        stack.push(V);

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int num = stack.pop();

            if (visited[num]) { //여기서 방문했는지 확인함으로써 stack에 중복된 값이 들어가게되더라도 방문을 했다면 while문을 continue하여 넘어갈 수 있다
                continue;
            }
            else {
                sb.append(num).append(" ");
                visited[num] = true;
            }

            ArrayList<Integer> adjacent = nodes[num];
            if (!adjacent.isEmpty()) {
                for (Integer integer : adjacent) { //역순 정렬로 큰 순서대로 나옴

                    if (!visited[integer]) {
                        stack.push(integer); //이 if문 안에서 방문처리를 하는것이 아닌, 일단 스택에 넣어놓고 생각한다
                    }
                }
            }
        }
        return sb.toString();
    }

    static String bfs(ArrayList<Integer>[] nodes, boolean[] visited, int V) {
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
        return sb.toString();
    }
}
