package dataStructure.boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //문자열 입력받고 문자열을 하나씩 쪼개야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] charArray = s.toCharArray();

        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }


        //숫자 입력받기
        int count = Integer.parseInt(br.readLine());

        //스택 2개 생성
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        //문자열을 모두 1번 스택에 넣기
        for (Character c : charList) {
            stack1.push(c);
        }

        while (count > 0) {

            String order = br.readLine();

            //L일경우 1번스택 제일 위에꺼 2번스택넣기
            if (order.equals("L")) {
                if (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            //D일경우 2번스택 제일 위에꺼 1번스택으로
            if (order.equals("D")) {
                if (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
            }

            //B일경우 1번스택 제일 위에꺼 없애기
            if (order.equals("B")) {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            }

            //P일경우 1번 스택에 문자 넣기
            if (order.startsWith("P")) {
                String[] strings = order.split(" ");
                char c = strings[1].charAt(0);
                stack1.push(c);
            }

            count --;
        }

        //스택 1을 모두 pop해서 스택 2로 옮기면 순서대로 나열됨
        while (!(stack1.empty())) {
            stack2.push(stack1.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!(stack2.empty())) {
            stringBuilder.append(stack2.pop());
        }

        System.out.println(stringBuilder);


    }
}
