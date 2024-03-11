package boj2910;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> ints = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] nums = br.readLine().split(" ");
        for (String num : nums) {
            ints.add(Integer.parseInt(num));
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer num : ints) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("countMap = " + countMap);



//        Collections.sort(ints, Collections.max());


    }
}
