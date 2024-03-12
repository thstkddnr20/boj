package dataStructure.boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //괄호 받기
        String line = br.readLine();

        //결과 값
        int num = 0;

        //스택
        Stack<Character> stack = new Stack<>();
        stack.push('('); // 첫번째 괄호는 무조건 (니까 넣어주고 반복문 1부터 시작

        //문자열 길이만큼 반복문돌리기
        for (int i = 1; i < line.length() ; i++) {
            char c = line.charAt(i);

            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                stack.pop();
                if (line.charAt(i - 1) == '(' && !stack.isEmpty()) {
                    num = num + (stack.size());
                }
                else if (line.charAt(i - 1) == ')') {
                    num = num + 1;
                }
            }
        }

        System.out.println(num);

        // ( 일경우 stack에 push

        // ) 일경우 전꺼가 (일경우는 레이저라는 뜻이므로 pop하고 개수세기, 아닐경우는 pop만

    }
}
