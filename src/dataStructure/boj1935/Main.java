package dataStructure.boj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정수 입력받기
        int count = Integer.parseInt(br.readLine());
        // String 입력받기
        String string = br.readLine();

        // for문을 돌려 String에서 아스키코드 가장 큰 값 찾아서 A = 1, B = 2 이런식으로 반환
        int biggest = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((int) c > biggest) {
                biggest = (int) c;
            }
        }

        // 위에서 찾은 정수만큼 배열 생성
        double[] nums = new double[biggest];

        // 배열의 길이만큼 for문으로 값 입력받아서 배열에 넣기
        for (int j = 0; j < count; j++) {
            nums[j] = Double.parseDouble(br.readLine());
        }

        // 스택 생성
        Stack<Double> stack = new Stack<>();

        // for문 돌려서 문자열의 아스키코드가 65 이상일 경우 배열의 값 스택에 집어넣기
        // 이하 일 경우 스택의 위에 두 개 꺼내서 계산 후 스택에 다시 집어넣기
        for (int k = 0; k < string.length(); k++) {
            char c1 = string.charAt(k);
            if ((int) c1 >= 'A') {
                stack.push(nums[(int) c1 - 'A']); // 'A'를 빼지 않고 직접 아스키 코드 값을 사용
            } else {
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                Double operation = operation(c1, pop2, pop1);
                stack.push(operation);
            }
        }
        Double pop = stack.pop();
        System.out.printf("%.2f", pop);
    }

    private static Double operation(char c, Double pop1, Double pop2) {
        if (c == '+') {
            return pop1 + pop2;
        } else if (c == '-') {
            return pop1 - pop2;
        } else if (c == '/') {
            return pop1 / pop2;
        } else if (c == '*') {
            return pop1 * pop2;
        }
        return null;
    }
}
