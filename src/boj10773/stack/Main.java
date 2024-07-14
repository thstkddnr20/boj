package boj10773.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.add(num);
            } else {
                stack.pop();
            }
        }

        int size = stack.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += stack.get(i);
        }

        System.out.println(result);
    }
}
