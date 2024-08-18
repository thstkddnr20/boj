package twopointer.boj2003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(sc.nextInt());
        }

        int sum = list.get(0);
        int result = 0;

        int left = 0;
        int right = 0;

        while (left < count && right < count) {
            if (left == right) {
                if (sum == m) {
                    result++;
                    if (right >= count - 1) {
                        break;
                    }
                    right++;
                    sum = sum + list.get(right);
                } else {
                    if (right >= count - 1) {
                        break;
                    }
                    right++;
                    sum = sum + list.get(right);
                }
            } else {
                if (sum == m) {
                    result++;
                    sum = sum - list.get(left);
                    left++;
                } else if (sum > m) {
                    sum = sum - list.get(left);
                    left++;
                } else {
                    if (right >= count - 1) {
                        break;
                    }
                    right++;
                    sum = sum + list.get(right);
                }
            }
        }
        System.out.println(result);
    }
}
