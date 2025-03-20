package search.dfsbfs.boj2606.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int setCount = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[computerCount + 1];

        for (int i = 1; i < computerCount + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < setCount + 1; i++) {
            String[] split = br.readLine().split(" ");
            Node i1 = nodes[Integer.parseInt(split[0])];
            Node i2 = nodes[Integer.parseInt(split[1])];

            if (!i1.adjacent.contains(i2)) {
                i1.adjacent.add(i2);
            }
            if (!i2.adjacent.contains(i1)) {
                i2.adjacent.add(i1);
            }
        }

        Node root = nodes[1];
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            count++;
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
        }

        System.out.println(count - 1);

    }



    static class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            adjacent = new LinkedList<>();
            this.marked = false;
        }
    }

}
