package boj11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            nums[i] = (Integer.parseInt(s[i]));
        }

        Arrays.sort(nums);

        int n = 0;
        int result = 0;

        for (int num : nums) {
            n = n + num;
            result += n;
        }

        System.out.println(result);
    }
}
