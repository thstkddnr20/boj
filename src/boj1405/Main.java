package boj1405;

import java.util.Scanner;

public class Main {
    static int N;
    //지났던 길 저장
    static int[] way;
    //percent
    static int[] percent = new int[4];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static float result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            percent[i] = sc.nextInt();
        }

        way = new int[N]; //0동, 1서, 2남, 3북

        if (N == 1) {
            System.out.println(1.0);
            System.exit(0);
        }

        find(0);
        System.out.println(result);

    }
    static void find(int depth) {
        if (depth == N) {
            //지났던 길들을 검사한다
            //지났던 길중 겹치는 것이 없을 경우
            if (calculateWay()) {
                float temp = 0;
                for (int i : way) {
                    float v = (float) percent[i] / 100;
                    if (temp == 0) {
                        temp = v;
                    }
                    else {
                        temp *= v;
                    }
                }
                //result에 확률을 더한다
                result += temp;
            }
            return;
        }

        //FIXME
        for (int i = 0; i < 4; i++) {
            if (percent[i] != 0) {
                way[depth] = i;
                find(depth + 1);
            }
        }
    }

    static boolean calculateWay() { //false일 경우 중복, true일 경우 중복X
        //way를 바탕으로 겹치는 길이 있는지 파악
        int x = N;
        int y = N;

        boolean[][] xy = new boolean[N * 2 + 1][N * 2 + 1];
        xy[x][y] = true;

        for (int i : way) {
            x += dx[i];
            y += dy[i];
            if (xy[x][y]) {
                return false;
            }
            xy[x][y] = true;
        }
        return true;
    }

}
