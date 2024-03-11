package boj2738;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        List<String[]> list1 = method1(m, br);
        List<String[]> list2 = method1(m, br);

        List<Integer[]> ints = method2(list1, list2);
        method3(n, m, ints);


    }


    public static List<String[]> method1(int num2, BufferedReader bufferedReader) throws IOException{

        String[] integers;
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < num2; i++) {
            integers = bufferedReader.readLine().split(" ");
            list.add(integers);
        }



        return list;
    }

    public static List<Integer[]> method2(List<String[]> list1, List<String[]> list2) {
        List<Integer[]> resultList = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            String[] array1 = list1.get(i);
            String[] array2 = list2.get(i);


            Integer[] sumArray = new Integer[list1.size()];

            for (int j = 0; j < list1.size(); j++) {
                sumArray[j] = Integer.parseInt(array1[j]) + Integer.parseInt(array2[j]);
            }
            resultList.add(sumArray);
        }
        return resultList;
    }

    public static void method3(int n, int m, List<Integer[]> list3) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                System.out.print(list3.get(i)[k] + " ");
            }
            System.out.println();
        }
    }
}
