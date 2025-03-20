package search.dfsbfs.boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class OneMore {

    static int M; //가로
    static int N; //세로
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;
    static int[][] map;
    static int[][] count;
    static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);

        map = new int[N][M];
        count = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int i1 = Integer.parseInt(strs[j]);
                if (i1 == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
                map[i][j] = i1;
            }
        }

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int xx = poll.x + dx[i];
                int yy = poll.y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
                    if (!visited[xx][yy] && map[xx][yy] != -1) {
                        visited[xx][yy] = true;
                        count[xx][yy] = count[poll.x][poll.y] + 1;
                        map[xx][yy] = 1;
                        q.add(new Pair(xx, yy));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                result = Math.max(result, count[i][j]);
            }
        }
        System.out.println(result);
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
