package boj11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int count = Integer.parseInt(s[0]);
        int money = Integer.parseInt(s[1]);

        List<Integer> coin = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        //1. money보다 같거나 작은 최댓값 구하기 -> 뒤에서 부터 탐색

        while (money > 0) {
            for (int i = coin.size() - 1; i >= 0; i--) {
                if (money == 0) {
                    break;
                }
                int c = coin.get(i);
                if (c <= money) {
                    int moneyCount = money / c;
                    result += moneyCount;
                    money = money - (c * moneyCount);
                }
            }
        }



        System.out.println(result);



        //2. 1번에서 구한 값으로 money를 나눠서 나머지가 최소가 나오게해야함

        //3. 남은 나머지 값으로 1,2번 반복

    }
}
