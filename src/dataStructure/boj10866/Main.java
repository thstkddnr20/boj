package dataStructure.boj10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        List<Integer> deque = new ArrayList<>();

        while (i > 0) {
            String s = br.readLine();

            if (s.startsWith("push")) {
                char c = s.charAt(5);
                String[] s1 = s.split(" ");
                int num = Integer.parseInt(s1[1]);

                if (c == 'f') {
                    deque.add(0, num);
                } else {
                    deque.add(num);
                }
            }

            if (s.startsWith("pop")) {
                char c = s.charAt(4);

                if (c == 'f' && !deque.isEmpty()) {
                    System.out.println(deque.remove(0));
                } else if (c == 'b' && !deque.isEmpty()) {
                    System.out.println(deque.remove(deque.size() - 1));
                } else {
                    System.out.println(-1);
                }
            }

            if (s.equals("size")) {
                System.out.println(deque.size());
            }

            if (s.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            if (s.equals("front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.get(0));
                }
                else {
                    System.out.println(-1);
                }
            }

            if (s.equals("back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.get(deque.size()-1));
                }
                else {
                    System.out.println(-1);
                }
            }


            i--;
        }
    }
}
