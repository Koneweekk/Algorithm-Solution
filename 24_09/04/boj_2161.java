import java.io.*;
import java.util.*;

class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 공통 변수
    int N;  // 공통 장수

    // 주요 실행 함수
    private void run() throws IOException {
        // 카드 장수
        N = Integer.parseInt(br.readLine());

        // 카드 번호가 오름차순으로 정리된 큐
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) { 
            queue.add(i+1);
        }

        StringBuilder sb = new StringBuilder();

        // 격번으로 카드를 버리기
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            if (isOdd) {
                sb.append(queue.poll());
                sb.append(" ");
            } else {
                queue.add(queue.poll());
            }
            isOdd = !isOdd;
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}