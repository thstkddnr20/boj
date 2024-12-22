package boj1927;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                queue.offer(num);
            }
            else {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
