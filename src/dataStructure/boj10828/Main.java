package dataStructure.boj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> stack = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        while (count > 0) {
            String string = br.readLine();
            if (string.startsWith("push")) {
                String[] s = string.split(" ");
                int i = Integer.parseInt(s[1]);
                push(stack, i);
            }
            if (string.equals("pop")) {
                Integer pop = pop(stack);
                System.out.println(pop);
            }
            if (string.equals("size")) {
                Integer size = size(stack);
                System.out.println(size);
            }
            if (string.equals("empty")) {
                Integer empty = empty(stack);
                System.out.println(empty);
            }
            if (string.equals("top")) {
                Integer top = top(stack);
                System.out.println(top);
            }
            count --;
        }

    }


    static List<Integer> push(List<Integer> list, Integer num) {
        list.add(num);
        return list;
    }

    static Integer pop(List<Integer> list) {
        int size = list.size();
        Integer i = -1;
        if (size - 1 >= 0) {
            i = list.get(size - 1);
            list.remove(size - 1);
            return i;
        } else {
            return i;
        }
    }

    static Integer size(List<Integer> list) {
        return list.size();
    }

    static Integer empty(List<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    static Integer top(List<Integer> list) {
        if (list.isEmpty()) {
            return -1;
        }
        else {
            return list.get(list.size() - 1);
        }
    }


}
