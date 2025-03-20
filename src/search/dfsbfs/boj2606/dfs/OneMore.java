package search.dfsbfs.boj2606.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OneMore {

    static Node[] com;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int conn = Integer.parseInt(br.readLine());

        com = new Node[num + 1];
        visited = new boolean[num + 1];
        visited[1] = true;
        for (int i = 1; i <= num; i++) {
            com[i] = new Node(i);
        }

        for (int i = 0; i < conn; i++) {
            String[] split = br.readLine().split(" ");
            int i1 = Integer.parseInt(split[0]);
            int i2 = Integer.parseInt(split[1]);
            com[i1].add(com[i2]);
            com[i2].add(com[i1]);
        }

        System.out.println(dfs());
    }

    static int dfs() {
        Stack<Node> stack = new Stack<>();
        stack.push(com[1]);

        int count = 0;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            count++;
            List<Node> nodes = pop.nodes;
            for (Node n : nodes) {
                if (!visited[n.num]) {
                    visited[n.num] = true;
                    stack.push(com[n.num]);
                }
            }
        }
        return count - 1;
    }

    static class Node {
        int num;
        List<Node> nodes;

        public Node(int num) {
            this.num = num;
            this.nodes = new ArrayList<>();
        }

        public void add(Node node) {
            nodes.add(node);
        }
    }
}
