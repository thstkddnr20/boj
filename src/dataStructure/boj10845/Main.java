package dataStructure.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main { // 리스트로 Queue 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();


        while (i > 0) {
            String s = br.readLine();

            if (s.startsWith("push")) {
                String[] s1 = s.split(" ");
                String s2 = s1[1];
                queue.add(Integer.parseInt(s2));
            }

            if (s.equals("pop")) {
                if (!queue.isEmpty()) {
                    Integer remove = queue.remove(0);
                    System.out.println(remove);
                }
                else{ System.out.println(-1);}

            }

            if (s.equals("size")) {
                System.out.println(queue.size());
            }

            if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                }
                else{ System.out.println(0);}

            }

            if (s.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.get(0));
                }
                else{ System.out.println(-1);}

            }

            if (s.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.get(queue.size() - 1));
                }
                else{ System.out.println(-1);}

            }


            i--;
        }
    }
}
