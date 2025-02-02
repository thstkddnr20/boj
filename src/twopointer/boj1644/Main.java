package twopointer.boj1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) { //1은 소수가 아님
            System.out.println(0);
            System.exit(0);
        }

        //N까지의 소수 만들기
        List<Integer> integers = makeArr(N);

        for (int i = 0; i < integers.size(); i++) {
            long sum = integers.get(i);
            for (int j = i + 1; j < integers.size(); j++) {
                sum += integers.get(j);
                if (sum > N) {
                    break;
                } else if (sum == N) {
                    result++;
                    break;
                }
            }
        }

        if (integers.get(integers.size() - 1) == N) { //마지막 요소가 N과 같은지, 즉 N이 소수인지
            result++;
        }

        System.out.println(result);

    }

    static List<Integer> makeArr(int size) {
        boolean[] booleans = new boolean[size + 1];

        for (int i = 0; i < booleans.length; i++) { //모두 true로 넣어놓고
            booleans[i] = true;
        }

        booleans[0] = booleans[1] = false; //0, 1은 소수가 아님

        for (int i = 2; i * i <= size; i++) {
            if (booleans[i]) { //소수라면
                for (int j = i * i; j <= size; j += i) {
                    booleans[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                list.add(i);
            }
        }
        return list;


    }
}
