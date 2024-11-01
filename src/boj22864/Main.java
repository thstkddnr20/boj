package boj22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int fatigueUpRate = Integer.parseInt(s[0]);
        int workRate = Integer.parseInt(s[1]);
        int fatigueDownRate = Integer.parseInt(s[2]);
        int burnoutRate = Integer.parseInt(s[3]);

        int hour = 1;

        int fatigue = 0;
        int work = 0;

        if (fatigueUpRate > burnoutRate) {
            System.out.println(0);
            System.exit(0);
        }

        while (hour <= 24) {
            if (fatigue <= burnoutRate - fatigueUpRate) {
                fatigue = fatigue + fatigueUpRate;
                work = work + workRate;
                hour++;
            } else {
                fatigue = fatigue - fatigueDownRate;
                if (fatigue < 0) {
                    fatigue = 0;
                }
                hour++;
            }
            //일할 수 있는지 없는지 확인

            //일할 수 있으면 일 하기

            //없으면 피로도 줄이기

        }

        System.out.println(work);

    }


}
