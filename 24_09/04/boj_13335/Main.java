package boj_13335;
import java.io.*;
import java.util.*;

public class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 공통 변수
    int N;  // 차량수
    int w;  // 다리의 단위 길이
    int L;  // 다리의 최대 하중

    // 주요 실행함수
    private void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값 할당
        N = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 차량 무게들을 큐에 할당
        Queue<Integer> truckQueue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truckQueue.add(Integer.parseInt(st.nextToken()));
        }

        // 다리 상태를 큐로 표현
        Queue<Integer> bridgeQueue = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            // 다리 빈공간은 0으로 표현
            bridgeQueue.add(0);
        }

        // 트럭 이동 시뮬레이션
        int currentLoad = 0;  // 다리 현재 하중
        int count = 0;  // 다리를 지나간 트럭 대수
        int time = 0;  // 지금까지 걸린 시간
        while(count < N) {
            // 앞 칸 이동
            int front = bridgeQueue.poll();
            // 앞 칸이 트럭인 경우
            if (front > 0) {
                count++;
                currentLoad -= front;
            }

            // 다음 트럭이 없거나 다음 트럭이 들어오면 최대 하중을 넘을 경우
            if (truckQueue.isEmpty() || currentLoad + truckQueue.peek() > L) {
                bridgeQueue.add(0);
            } 
            // 다음 트럭이 들어올 하중의 여유가 존재하는 경우
            else {
                int truck = truckQueue.poll();
                bridgeQueue.add(truck);
                currentLoad += truck;
            }

            time++;
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}
