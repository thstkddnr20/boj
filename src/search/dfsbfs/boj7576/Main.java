package search.dfsbfs.boj7576;

import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] tomato;
    static List<Queue<Pair>> list;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //가로
        N = sc.nextInt(); //세로

        list = new ArrayList<>();
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int i1 = sc.nextInt();
                if (i1 == 1) {
                    Queue<Pair> queue = new ArrayDeque<>();
                    queue.add(new Pair(j, i));
                    list.add(queue);
                }
                tomato[i][j] = i1;
            }
        }

        if (list.isEmpty()) {
            //1이 나오지 않았다는 것
            System.out.println(-1);
            System.exit(0);
        }
        bfs();

        // bfs를 완료 후 0이 남아있는것을 확인
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    result = -1;
                    break loop;
                }
            }
        }
        System.out.println(result);
    }

    static void bfs() {
        while (!list.isEmpty()) {
            List<Integer> removeIndex = new ArrayList<>();
            int tomatoCount = 0;
            for (int j = 0; j < list.size(); j++) {

                Queue<Pair> queue = list.get(j);
                int queueSize = queue.size();

                for (int i = 0; i < queueSize; i++) {
                    Pair poll = queue.poll();
                    int x = poll.x;
                    int y = poll.y;

                    //상
                    if (y - 1 >= 0) {
                        if (tomato[y - 1][x] == 0) {
                            queue.add(new Pair(x, y - 1));
                            tomato[y - 1][x] = 1;
                            tomatoCount++;
                        }
                    }

                    //하
                    if (y + 1 < N) {
                        if (tomato[y + 1][x] == 0) {
                            queue.add(new Pair(x, y + 1));
                            tomato[y + 1][x] = 1;
                            tomatoCount++;
                        }
                    }

                    //좌
                    if (x - 1 >= 0) {
                        if (tomato[y][x - 1] == 0) {
                            queue.add(new Pair(x - 1, y));
                            tomato[y][x - 1] = 1;
                            tomatoCount++;
                        }
                    }

                    //우
                    if (x + 1 < M) {
                        if (tomato[y][x + 1] == 0) {
                            queue.add(new Pair(x + 1, y));
                            tomato[y][x + 1] = 1;
                            tomatoCount++;
                        }
                    }
                }

                //queue에 들어갈 수 있는 안익은 토마토가 없으면 queue를 null할당
                if (queue.isEmpty()) {
                    removeIndex.add(j);
                    break;
                }

            }
            removeIndex.sort(Comparator.reverseOrder());
            for (Integer index : removeIndex) {
                int toInt = index;
                list.remove(toInt);
            }
            if (tomatoCount != 0) {
                result++;
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
