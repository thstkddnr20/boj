package boj32654;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Node[] nodes = new Node[num + 1];
        for (int i = 1; i < num + 1; i++) {
            Node node = new Node(i);
            nodes[i] = node;
        }

        Node firstNode = null;

        for (int i = 0; i < num; i++) {
            int node = sc.nextInt();
            int adjacent = sc.nextInt();
            Node getNode = nodes[node];
            if (i == 0) {
                firstNode = getNode;
            }
            getNode.next = nodes[adjacent];
        }

        int i = checkNodeContainOne(num, firstNode);
        System.out.println(i);
    }

    public static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int checkNodeContainOne(int n, Node node) {
        Node currentNode = node;
        if (currentNode.value == 1) {
            return -1;
        }
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (currentNode == null) {
                return depth;
            }
            if (currentNode.value == 1) {
                return depth;
            }
            currentNode = currentNode.next;
            depth++;
        }
        return depth;
    }
}
