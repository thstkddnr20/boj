package boj5883;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Integer> original = new LinkedList<>(); //등장하는 수 모두 저장
        Set<Integer> nums = new HashSet<>(); //등장하는 수 중복 없이 저장
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            nums.add(n);
            original.add(n);
        }

        int count;
        Integer before;
        Integer answer = 0;
        for (Integer integer : nums) {
            count = 1;
            before = 0;
            List<Integer> copy = new LinkedList<>(original);
            copy.removeAll(List.of(integer));
            for (Integer i : copy) {
                if (before.equals(i)) {
                    count++;
                }
                before = i;
            }
            answer = Math.max(answer, count);

        }

        System.out.println(answer);

    }
}


