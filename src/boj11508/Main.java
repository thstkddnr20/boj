package boj11508;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;

        if (N < 3) {
            for (int i = 0; i < N; i++) {
                result += sc.nextInt();
            }

            System.out.println(result);
            System.exit(0);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list); // 내림차순으로 해서 거꾸로 계산해야했음

        int iter = list.size() / 3;
        int remain = list.size() % 3;

        for (int i = 1; i <= iter; i++) {
            int i1 = i * 3 - 1;
            result += list.get(i1) + (list.get(i1 - 1));
        }

        if (remain != 0) {
            for (int i = 0; i < remain; i++) {
                result += list.get(list.size() - 1 - i);
            }
        }

        System.out.println(result);

    }
}
