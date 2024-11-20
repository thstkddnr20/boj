package boj1966;

import java.io.IOException;
import java.util.*;

public class Main {

    public static List<Node> queue = new LinkedList<>(); //ArrayList로 했을 때의 차이 확인
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for (int i = 0; i < testcase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int point = sc.nextInt();
                if (j == M) {
                    queue.add(new Node(true, point));
                } else {
                    queue.add(new Node(point));
                }
            }
            sb.append(calculate()).append("\n");
            queue.clear();
        }

        System.out.println(sb);
    }

    private static int calculate() {
        int count = 0;
        //반복 시작
        while (true) {
            int maxPoint = 0;
            //maxPoint 갱신
            for (Node node : queue) {
                maxPoint = Math.max(maxPoint, node.point);
            }

            //맨 앞 확인
            Node node = queue.get(0);
            if (node.point == maxPoint) {
                count++;
                if (node.flag) {
                    break;
                }
                queue.remove(0);
            } else {
                queue.add(queue.remove(0));
            }
        }
        return count;

    }

    public static class Node {
        boolean flag;
        Integer point;

        public Node(boolean flag, Integer point) {
            this.flag = flag;
            this.point = point;
        }

        public Node(Integer point) {
            this.point = point;
        }
    }


}
