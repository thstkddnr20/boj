package boj10655;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Pair> listOfPairs = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] s = br.readLine().split(" ");
            listOfPairs.add(new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }

        int[] ints = methodForABC(count, listOfPairs);
        int where = method(count, listOfPairs, ints);

        listOfPairs.remove(where); //가장 큰 값을 제거
        int answer = 0;

        for (int i = 1; i < count - 1; i++) {
            int i1 = listOfPairs.get(i - 1).x - listOfPairs.get(i).x;
            int i2 = listOfPairs.get(i - 1).y - listOfPairs.get(i).y;
            answer = answer + abs(i1) + abs(i2);
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] methodForABC(int count, List<Pair> list) { // ax+by+c = 0 에서 abc 가져오기
        if ((list.get(0).x != list.get(count-1).x) && (list.get(0).y != list.get(count-1).y)){
            int a = (list.get(count - 1).y - list.get(0).y) * -1;
            int b = list.get(count - 1).x - list.get(0).x;
            int c = (a * list.get(0).x) + b * (list.get(0).y) * -1;

            return new int[]{a, b, c};
        }
        else {
            return null;
        }
    }

    private static int method(int count, List<Pair> list, int[] ints) { // 가장 큰 값 찾고 인덱스 어딘지 찾기
        int i = 1;
        int where = 0;
        int max = 0;

        if (ints != null) {
            while (i < count - 1) {
                int i1 = ints[0] * list.get(i).x + ints[1] * list.get(i).y + ints[2];
                if (abs(i1) > max) {
                    max = abs(i1);
                    where = i;
                }
                i++;
            }
        }
        else {
            while (i < count - 1) {
                int i1 = abs(list.get(i).x - list.get(0).x) + abs(list.get(i).y - list.get(0).y);
                if (i1 > max) {
                    max = i1;
                    where = i;
                }
                i++;
            }
        }

        return where;
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
