package boj32653;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Long> nums = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            nums.add(sc.nextLong() * 2);
        }

        while (nums.size() != 1) {
            Long result = lcm(nums.get(0), nums.get(1));
            nums.remove(1);
            nums.remove(0);
            nums.add(0, result);
        }

        System.out.println(nums.get(0));
    }

    public static Long gcd(Long a, Long b) {
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static Long lcm(Long a, Long b) {
        return (a * b) / gcd(a, b);
    }
}
