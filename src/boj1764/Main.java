package boj1764;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (set.contains(s)) {
                result.add(s);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(result.size());
        System.out.println(sb);
    }
}
