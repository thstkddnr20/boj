package dataStructure.boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for (int i = 0; num > i; i++) {
            String s = br.readLine();
            System.out.println(solve(s));
        }
    }

    public static String solve(String string) {
        Stack<Character> stack = new Stack<>();

        for (int j = 0; string.length() > j; j++) {
            char c = string.charAt(j);

            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
