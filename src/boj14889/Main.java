package boj14889;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] player;
    static int result = Integer.MAX_VALUE;
    static int[] startTeam;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        player = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                player[i][j] = sc.nextInt();
            }
        }

        startTeam = new int[N / 2];

        recursion(0, 1);
        System.out.println(result);
    }

    //N이 4일때
    static void recursion(int depth, int index) { //depth = 0일때 선수1, depth = 1일때 선수2, depth = 2일때 검증
        if (depth == N / 2) {
            List<Integer> linkTeam = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    linkTeam.add(i);
                }
            }

            int calculateStart = 0;
            int calculateLink = 0;

            for (int i = 0; i < linkTeam.size(); i++) {
                for (int j = i + 1; j < linkTeam.size(); j++) {
                    calculateStart += player[startTeam[i]][startTeam[j]];
                    calculateStart += player[startTeam[j]][startTeam[i]];
                    calculateLink += player[linkTeam.get(i)][linkTeam.get(j)];
                    calculateLink += player[linkTeam.get(j)][linkTeam.get(i)];
                }
            }

            result = Math.min(result, Math.abs(calculateLink - calculateStart));


            return;
        }

        //앞에거 N / 2개 결정되면 나머지는 정해져있음
        //앞에거 N / 2개만 결정하면됨
        //depth가 0일때 arr[1] 넣기
        //depth가 1일때 arr[2] 넣기
        for (int i = index; i <= N; i++) { //넣을 값
            if (!visited[i]) {
                //전 값보다 큰 경우에만 넣음
                if (depth > 0) {
                    if (startTeam[depth - 1] >= i) {
                        continue;
                    }
                }
                startTeam[depth] = i;
                visited[i] = true;
                recursion(depth + 1, index + 1);
                visited[i] = false;
            }

        }

        //1번재귀에서 1, 2번재귀에서 2, return 후 3번재귀에서 3



    }
}
