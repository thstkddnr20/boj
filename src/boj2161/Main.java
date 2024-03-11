package boj2161;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        List<Integer> getNums = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            nums.add(i+1);
        }

        while (nums.size() >= 2) {
            Integer remove = nums.remove(0);
            getNums.add(remove);

            nums.add(nums.get(0));
            nums.remove(0);
        }

        getNums.add(nums.get(0));

        for (Integer getNum : getNums) {
            bw.write(getNum.toString());
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
