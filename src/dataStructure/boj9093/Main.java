package dataStructure.boj9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for (int a = 0; num > a; a++) {
            String string = br.readLine();
            String[] split = string.split(" ");
            List<String> result = new ArrayList<>();
            List<String> strings = pushAndPop(split, result);
            System.out.println(String.join(" ", strings));
        }


    }

    static List<String> pushAndPop(String[] split, List<String> result) {
        List<String> stack = new ArrayList<>();
        for (int i = 0; split.length > i; i++) {
            char[] charArray = split[i].toCharArray();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; charArray.length > j; j++) {
                stack.add(String.valueOf(charArray[j])); // [h,e,l,l,o]
            }
            for (int l = stack.size() - 1, k = 0; l >= 0; l--, k++) {
                sb.append(stack.get(l));
            }
            String string = sb.toString();
            result.add(string);
            stack.clear();
        }

        return result;
    }



}
