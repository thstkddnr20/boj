package boj18258;

import java.io.*;

public class Main {

    public static int[] arr = new int[2_000_001];

    public static int front = 0;
    public static int back = 0;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            if (string.startsWith("push")) {
                int x = Integer.parseInt(string.split(" ")[1]);
                push(x);
            } else if (string.equals("pop")) {
                bw.write(String.valueOf(pop()));
                bw.newLine();
            } else if (string.equals("size")) {
                bw.write(String.valueOf(size()));
                bw.newLine();
            } else if (string.equals("empty")) {
                bw.write(String.valueOf(empty()));
                bw.newLine();
            } else if (string.equals("front")) {
                bw.write(String.valueOf(front()));
                bw.newLine();
            } else if (string.equals("back")) {
                bw.write(String.valueOf(back()));
                bw.newLine();
            }
        }
        bw.flush();

    }

    public static void push(int x) {
        if (size == 0) { // 배열이 비어있을 때
            front++;
            back++;
            arr[front] = x;
            size++;
            return;
        }
        back++;
        arr[back] = x;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        }
        if (front == back) {
            front++;
            back++;
            size--;
            return arr[front - 1];
        }
        front++;
        size--;
        return arr[front - 1];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    public static int front() {
        if (size == 0) {
            return -1;
        }
        return arr[front];
    }

    public static int back() {
        if (size == 0) {
            return -1;
        }
        return arr[back];
    }
}
