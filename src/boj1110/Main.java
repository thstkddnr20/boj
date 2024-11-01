package boj1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int initialNum = num;

        int count = 0;

        while (true) {
            StringBuilder sb = new StringBuilder();
            if (num < 10) {
                num = Integer.parseInt(String.valueOf(sb.append(num).append(num)));
                count++;
            } else {
                //앞자리와 뒷자리 분리
                String s = String.valueOf(num);
                int front1 = Integer.parseInt(String.valueOf(s.charAt(0)));
                int back1 = Integer.parseInt(String.valueOf(s.charAt(1)));

                //앞자리와 뒷자리 더하기
                int plus = front1 + back1;


                if (plus < 10) {
                    sb.append(back1).append(plus);
                    String val = sb.toString();
                    num = Integer.parseInt(val);
                    count++;
                }
                else {
                    //더한 값의 앞자리와 뒷자리 분리
                    String s2 = String.valueOf(plus);
                    int back2 = Integer.parseInt(String.valueOf(s2.charAt(1)));

                    //나온 뒷자리와 기존의 뒷자리 더하기
                    sb.append(back1).append(back2);
                    String val = sb.toString();
                    num = Integer.parseInt(val);
                    count++;
                }
            }

            //initialNum값이 나올 때 까지 반복
            if (num == initialNum) {
                break;
            }
        }

        System.out.println(count);
    }
}
