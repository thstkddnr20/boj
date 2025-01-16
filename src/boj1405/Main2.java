package boj1405;

import java.util.*;

public class Main2 { //Main에 비해 메모리 15배, 시간 6배 정도 사용하였다
    static int N;
    //지났던 길 저장
    static int[] way;
    //percent
    static double[] percent = new double[4];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static double result;

    static List<String> visited = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            percent[i] = (double) sc.nextInt() / 100;
        }

        way = new int[N]; //0동, 1서, 2남, 3북

        if (N == 1) {
            System.out.println(1.0);
            System.exit(0);
        }

        visited.add("0,0");
        find(0, 0, 0, 1);
        System.out.println(result);

    }
    static void find(int depth, int x, int y, double total) {
        if (depth == N) {
            //지났던 길들을 검사한다 -> 넣기 전에 미리 검사하고 넣는다
            //지났던 길중 겹치는 것이 없을 경우
            result += total;
            return;
        }

        for (int i = 0; i < 4; i++) {
            //이전에 동쪽으로갔다면, 다음에 서쪽을 제외한 3가지 방향으로 갈 수 있다
            if (percent[i] == 0) {
                continue;
            }
            if (depth > 0) {
                if (way[depth - 1] % 2 == 1) {
                    if (way[depth - 1] - 1 == i) continue;
                }
                else {
                    if (way[depth - 1] + 1 == i) continue;
                }
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            String s = nx + "," + ny;

            if (!visited.contains(s)) {
                way[depth] = i;
                visited.add(s);
                find(depth + 1, nx, ny, total * percent[i]);
                visited.remove(s);
            }

        }
    }


}
