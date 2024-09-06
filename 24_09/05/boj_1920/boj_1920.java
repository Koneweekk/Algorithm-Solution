import java.io.*;
import java.util.*;

class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 공용 필드
    int N;
    int M;
    HashSet<Integer> A = new HashSet<>();

    // 주요 실행함수
    void run() throws IOException {
        // 입력값 할당
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());

        // 다음 숫자들이 A에 포함되는지 확인
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            sb.append(A.contains(m) ? 1: 0);
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}