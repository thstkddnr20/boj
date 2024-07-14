package boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                list.add(num);
            } else {
                int size = list.size();
                list.remove(size - 1);
            }
        }

        int size = list.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += list.get(i);
        }

        System.out.println(result);
    }
}
