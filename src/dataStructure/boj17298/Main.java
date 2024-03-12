package dataStructure.boj17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");

        Integer[] ans = new Integer[count];
        Stack<Integer> stack = new Stack<>();

        for (String num : nums) {
            stack.push(Integer.parseInt(num));
        }

        Stack<Integer> resultStack = new Stack<>();
        resultStack.push(-1); // 초기값 설정

        for (int i = count - 1; i >= 0; i--) {
            try {
                while (stack.peek() >= resultStack.peek()) {
                    resultStack.pop();
                }
                ans[i] = resultStack.peek();
            } catch (java.util.EmptyStackException e) {
                ans[i] = -1;
            }

            resultStack.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ans.length; j++) {
            sb.append(ans[j]).append(' ');
        }
        System.out.println(sb);
    }
}
/**
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.util.Arrays;
 * import java.util.Stack;
 *
 * public class Main {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         int count = Integer.parseInt(br.readLine());
 *
 *         String[] nums = br.readLine().split(" ");
 *
 *         Integer[] ans = new Integer[count];
 *         //임시로 정수를 저장하는 공간 루프 돌면 다시 0으로 세팅
 *         int save = 0;
 *
 *         Stack<Integer> stack = new Stack<>();
 *         Stack<Integer> cloneStack = new Stack<>();
 *
 *         for (String num : nums) {
 *             stack.push(Integer.parseInt(num));
 *             cloneStack.push(Integer.parseInt(num));
 *         }
 *         //반복문 i = 0부터 count까지
 *         //
 *         for (int i = 0; i < count; i++) {
 *             for (int j = i+1; j < count; j++) {
 *                 if (stack.peek() > stack.get(i)) {
 *                     save = stack.pop();
 *                 } else {
 *                     stack.pop();
 *                 }
 *             }
 *             if (save == 0) {
 *                 ans[i] = -1;
 *             } else {
 *                 ans[i] = save;
 *             }
 *             stack = (Stack<Integer>) cloneStack.clone();
 *         }
 *         ans[ans.length - 1] = -1;
 *         System.out.println(Arrays.toString(ans));
 *         //스택 맨 마지막은 무조건 -1
 *
 *
 *
 *     }
 * }
 */