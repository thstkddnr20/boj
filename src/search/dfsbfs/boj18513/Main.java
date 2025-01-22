package search.dfsbfs.boj18513;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N; //샘터의 수
    static int K; //놓을 집의 개수
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean[] visited = new boolean[203_000_000];

    static int maxCounter; //주어진 불행에 대해 탐색해야 하는 수
    static long result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        maxCounter = N * 2;

        for (int i = 0; i < N; i++) {
            int i1 = sc.nextInt();
            //샘터는 방문처리하고
            visited[i1 + 100_100_001] = true;

            //앞뒤로 하나씩 넣음
            queue.add(i1 - 1 + 100_100_001);
            queue.add(i1 + 1 + 100_100_001);
        }

        int misfortune = 1;
        int counter = 0;
        int housePlaced = 0;
        while (!queue.isEmpty()) {
            if (counter == maxCounter) {
                misfortune++; //불행도를 1 늘리고
                counter = 0; //카운터를 초기화하고
                maxCounter = queue.size(); //할당된 새로운 불행도를 늘려줄 만큼의 maxCounter 할당 -> 넓이 우선탐색에서 새로운 depth를 얼마나 돌릴것인지
            }

            Integer poll = queue.poll();
            counter++; //꺼내면 카운터 무조건 올린다

            if (visited[poll]) { //이조건에 걸리면 이미 지어졌거나, 샘터다
                continue;
            }

            visited[poll] = true;
            result += misfortune;
            housePlaced++;
            if (housePlaced == K) {
                break;
            }

            queue.add(poll - 1);
            queue.add(poll + 1);

        }

        System.out.println(result);
    }
}
