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

    public static int checkNodeContainOne(int n, Node node) { //1을 포함한 순환 참조라면 -1, 1이 없으면 0, 1이 있는데 순환참조가 아닌경우: 1이 나오기 전까지 깊이를 계산
        Node currentNode = node;
        int depth = 0;
        boolean circular = false;
        boolean metOne = false;
        for (int i = 0; i < n; i++) {
            if (i != 0 && currentNode == node) {
                circular = true;
            }
            if (currentNode.value == 1) {
                metOne = true;
            }
            currentNode = currentNode.next;
            depth++;
        }

        if (circular && metOne) {
            return -1;
        }
        if (!metOne && circular) {
            return 0;
        }
        return depth;
    }
}
