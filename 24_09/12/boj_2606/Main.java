import java.util.*;
import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void run() throws IOException {
    // 1. 입력값 변수에 할당
    int N = Integer.parseInt(br.readLine());  // 컴퓨터 개수
    int M = Integer.parseInt(br.readLine());  // 간선 개수

    // 2. 컴퓨터간 연결 관계를 통해 그래프 표시
    // 2.1 그래프 초기화
    List<List<Integer>> computerGraph = new ArrayList<>();
    for (int i = 0; i < N+1; i++) {
      computerGraph.add(new ArrayList<>());
    }
    // 2.2 그래프에 간선 정보 입력
    for (int i = 0; i < M; i++) {
      // 간선 정보 입력받기
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      // 그래프에 표시
      computerGraph.get(node1).add(node2);
      computerGraph.get(node2).add(node1);
    }

    // 3. 그래프를 순회하며 1번 컴퓨터와 연결된 컴퓨터 개수 세기
    // 3.1 관련 변수 설정
    Stack<Integer> stack = new Stack<>();  // dfs를 위한 스택
    stack.add(1);
    int count = 0;  // 1번 컴퓨터와 연결된 컴퓨터 개수
    boolean[] isVisited = new boolean[N+1];  // 방문 표시를 위한 배열
    isVisited[1] = true;
    // 3.2 스택을 순회하며 방문 표시
    while (!stack.isEmpty()) {
      int current = stack.pop();  // 현재 탐색 노드
      for (int next : computerGraph.get(current)) {
        // 다음 노드가 이미 방문 했으면 다른 노드 탐색
        if (isVisited[next]) continue;
        // 다음 노드 스택에 추가하고 정보 변경
        stack.add(next);
        count++;
        isVisited[next] = true;
      }
    }

    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}