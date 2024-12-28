package search.dfsbfs.boj21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        String[][] map = new String[N][M];
        boolean[][] visited = new boolean[N][M];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String string = split[j];
                if (string.equals("I")) {
                    startX = i;
                    startY = j;
                }
                map[i][j] = string;
            }
        }

        int result = 0;

        //bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();

            if (visited[poll.x][poll.y]) {
                continue;
            }

            int x = poll.x;
            int y = poll.y;

            //방문 처리
            visited[x][y] = true;

            //상하좌우 체크 후 큐에 넣음 1.벽이면 못넣음 2.배열 초과하면 못넣음 3.방문 한것은 일단 넣자 위에서 방문 체크 하니까
            //상
            if (x - 1 >= 0 && !map[x - 1][y].equals("X")) {
                queue.add(new Pair(x - 1, y));
            }

            //하
            if (x + 1 < N && !map[x + 1][y].equals("X")) {
                queue.add(new Pair(x + 1, y));
            }

            //좌
            if (y - 1 >= 0 && !map[x][y - 1].equals("X")) {
                queue.add(new Pair(x, y - 1));
            }

            //우
            if (y + 1 < M && !map[x][y + 1].equals("X")) {
                queue.add(new Pair(x, y + 1));
            }

            //꺼내온 값 확인

            String string = map[x][y];
            if (string.equals("P")) {
                result++;
            }
        }

        if (result != 0) {
            System.out.println(result);
        }
        else {
            System.out.println("TT");
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
