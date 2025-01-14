package boj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BacktrackingMain {
    static int N;
    static String[] words; //단어 저장
    static List<Character> arr = new ArrayList<>(); //알파벳이 어떤것이 있는지 중복없이 받는 list
    static boolean[] visited = new boolean[10]; //방문했는지 확인
    static int[] alphabetValue; //알파벳의 가중치를 담을 배열
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
            for (int j = 0; j < words[i].length(); j++) { //입력들어온 알파벳의 char을 루프돌려 중복없이 arr에 추가
                if (!arr.contains(words[i].charAt(j))) { //중복 거르기
                    arr.add(words[i].charAt(j));
                }
            }
        }

        alphabetValue = new int[arr.size()]; //가중치를 담을 배열 할당, 각각의 arr의 인덱스에 맞는 배열이므로 arr.size()로 생성

        recursion(0);
        System.out.println(max);
    }

    static void recursion(int depth) { //depth는 가중치를 할당할 때 index로 사용됨
        //종료 조건, 깊이와 탐색해야하는 알파벳의 개수가 같을때 모두 탐색했다는 것
        if (depth == arr.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < words[i].length(); j++) { //ex)가중치가 2이고 AAA라면 2 -> 20 -> 22 -> 220 -> 222가 됨
                    num *= 10;
                    num += alphabetValue[arr.indexOf(words[i].charAt(j))]; //각각의 알파벳에 대한 가중치 가져오기 -> i번째 단어중 j번째 char을 가져오는데, 해당 char이 arr의 인덱스 몇번인지
                }
                sum += num;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                alphabetValue[depth] = i;
                recursion(depth + 1);
                visited[i] = false;
                alphabetValue[depth] = 0;
            }
        }
    }

    /**
     * ex)
     * 2
     * AAA
     * AAA
     *
     * arr = [A]
     * alphabetValue.size() = arr.size() = 1
     * alphabetValue의 0번째에 0~9까지 반복문으로 들어가게 됨
     *
     * 종료조건에서 arr.indexOf(A) = 0 이므로 alphabetValue의 0번째만 호출됨
     * sum = 0, 111 + 111 = 222, 222 + 222 = 444, 666 ~ 999 + 999 인 1998까지 갱신됨
     * Math.max에 의해서 max값이 최종적으로 1998로 할당
     */
}
