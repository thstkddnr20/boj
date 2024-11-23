package boj2417;

import java.util.Scanner;

public class Main {
    static long N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();

        search();
    }

    static void search(){
        long left = 0;
        long right = N;
        long result = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(Math.pow(mid, 2) >= N){
                right = mid - 1;
                result = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
