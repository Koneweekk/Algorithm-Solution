import java.util.*;
import java.io.*;

public class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    // 공통 변수 관련 필드
    int K;


    // 메인 함수
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    
    // 주요 실행 함수
    private void run() throws IOException {
        // 1. 입력값 변수에 할당
        K = Integer.parseInt(br.readLine());  // 트리의 레벨
        String[] numberTree = br.readLine().split(" ");  // 숫자 트리

        // 2. 트리 순회를 도와줄 큐 설정
        Queue<Integer> idxQueue = new ArrayDeque<>();
        int rootNode = (int) Math.pow(2, K-1) - 1;  // 루트 노드가 되는 중앙 인덱스
        idxQueue.add((int) Math.pow(2, K-1) -1);  // 루트 큐에 추가
        sb.append(numberTree[rootNode]);
        
        // 3. 트리의 레벨별로 다음 노드 탐색
        for (int i = 0; i < K-1; i++) {
            sb.append("\n");
            int curretLevelCount = (int) Math.pow(2, i);  // 현재 레벨의 노드 개수
            // 현재 레벨의 노드 탐색
            for (int j = 0; j < curretLevelCount; j++) {
                int interval = (int) Math.pow(2, K-i-2);
                int current = idxQueue.poll();
                // 좌측 자식 노드 추가
                int left = current - interval;
                idxQueue.add(left);
                sb.append(numberTree[left]).append(" ");
                // 우측 자식 노드 추가
                int right = current + interval;
                idxQueue.add(right);
                sb.append(numberTree[right]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
