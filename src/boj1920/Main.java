package boj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> hashSet = new HashSet<>();
        String[] split = br.readLine().split(" ");
        for (String s : split) {
            hashSet.add(Integer.valueOf(s));
        }

        int M = Integer.parseInt(br.readLine());
        String[] split2 = br.readLine().split(" ");
        List<Integer> resultList = new ArrayList<>();
        for (String s : split2) {
            int i = Integer.parseInt(s);
            if (hashSet.contains(i)) {
                resultList.add(1);
            } else {
                resultList.add(0);
            }
        }

        for (Integer i : resultList) {
            System.out.println(i);
        }
    }
}
