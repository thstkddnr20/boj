package boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        List<String> croatia = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (String string : croatia) {
            s = s.replace(string, "1");
        }

        System.out.println(s.length());


    }
}
