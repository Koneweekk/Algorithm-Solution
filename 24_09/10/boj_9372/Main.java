import java.util.*;
import java.io.*;

public class Main {
    // 입출력 관련 필드
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answerSB = new StringBuilder();
    // 공통 변수 관련 필드
    int T;


    // 메인 함수
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    
    // 주요 실행 함수
    private void run() throws IOException {
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            testCase();    
        }

        System.out.println(answerSB.toString());
    }

    
    // 각 테스트 케이스별 정답 구하기
    private void testCase() throws IOException {
        // 1. 입력값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 국가의 수
        int M = Integer.parseInt(st.nextToken());  // 비행기의 종류

        // 2. 비행기 간 경로를 담을 이중 배열 만들기
        List<List<Integer>> routeTree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            routeTree.add(new ArrayList<>());
        }

        // 3. 비행기 간 경로를 트리 형태로 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int country1 = Integer.parseInt(st.nextToken())-1;
            int country2 = Integer.parseInt(st.nextToken())-1;

            routeTree.get(country1).add(country2);
            routeTree.get(country2).add(country1);
        }
        
        // 4. 큐를 통해트리를 순회하며 노선 개수 세기
        int count = 0;  // 거쳐야하는 노선 개수
        boolean[] visited = new boolean[N];  // 나라들 방문 표시
        // 4.1 큐 초기 설정(0을 루트 노드로 설정하고 방문 표시)
        Queue<Integer> queue = new ArrayDeque<Integer>(Arrays.asList(0));
        visited[0] = true;
        // 4.2 큐가 빌 때까지 트리 순회
        while (!queue.isEmpty()) {
            int nowCountry = queue.poll();
            // 현재 나라와 연결된 노선 탐색
            for (Integer next : routeTree.get(nowCountry)) {
                // 이미 방문한 나라면 다음 노선 탐색
                if (visited[next]) continue;
                queue.add(next);
                count++;
                visited[next] = true;
            }
        }

        answerSB.append(count).append("\n");
    }
}
