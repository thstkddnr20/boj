package search.dfsbfs.boj7576;

import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] tomato;
    static int[][] distance;
    static Queue<Pair> queue = new ArrayDeque<>();
    static int result;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //가로
        N = sc.nextInt(); //세로

        tomato = new int[N][M];
        distance = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int i1 = sc.nextInt();
                if (i1 == 1) {
                    queue.add(new Pair(j, i));
                }
                tomato[i][j] = i1;
            }
        }

        bfs();

        // bfs 완료 후 distance 확인하여 result 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, distance[i][j]);
            }
        }

        // bfs를 완료 후 익을 수 있는 토마토인데 막혀서 distance가 0인 것 확인
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0 && distance[i][j] == 0) {
                    result = -1;
                    break loop;
                }
            }
        }
        System.out.println(result);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < dx.length; i++) {
                //queue에서 꺼내진 값에서 상하좌우 비교
                int nx = x + dx[i];
                int ny = y + dy[i];

                //tomato[y][x], Pair(x, y)이다
                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    //익을수 있는 토마토인가 && distance가 0으로 bfs를 돌지 않은 곳인가
                    if (tomato[ny][nx] == 0 && distance[ny][nx] == 0) {
                        queue.add(new Pair(nx, ny));
                        //이전 거리에 +1을 하여 distance 갱신
                        distance[ny][nx] = distance[y][x] + 1;
                    }
                }
            }

        }

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
