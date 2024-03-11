package dataStructure.boj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            queue.add(i);
        }

        while (n > 0) {
            for (int j = 1; j < k; j++) {
                queue.add(queue.remove());
            }

            result.add(queue.remove());

            n--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");

        for (int i = 0; i < result.size(); i++) {
            stringBuilder.append(result.get(i));

            if (i < result.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append(">");
        System.out.println(stringBuilder);

    }
}
