package search.dfsbfs.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];

        count[0][0] = 1;

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();
        System.out.println(count[N-1][M-1]);
    }

    public static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair poll = q.poll();

            //꺼낸것을 상하좌우 비교하여 큐에 추가
            for (int i = 0; i < 4; i++) {
                int i1 = dx[i] + poll.x;
                int i2 = dy[i] + poll.y;
                if (i1 >= 0 && i2 >= 0 && i1 < N && i2 < M) {
                    if (!visited[i1][i2] && map[i1][i2] == 1) {
                        visited[i1][i2] = true;
                        count[i1][i2] = count[poll.x][poll.y] + 1;
                        q.add(new Pair(i1, i2));
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
