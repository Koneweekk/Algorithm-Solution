import java.util.*;
import java.io.*;

// 정점 정보를 담을 클래스
class Node {
  int vertex;  // 정점 번호
  int cost;  // 비용

  public Node(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
  }
}


public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();
  StringTokenizer st;

  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 변수 할당
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 정점 개수
    int M = Integer.parseInt(st.nextToken()); // 간선 개수
    int start = Integer.parseInt(br.readLine()) - 1; // 시작점

    // 2. 비용 배열 산출
    // 2.1 초기 배열 선언
    List<Node>[] graph = new ArrayList[N];
    for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
    }
    // 2.2 간선 이동 비용 입력 받고 기록
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()) - 1;
      int v = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Node(v, w));
  }

    // 3. 다익스트라 연산에 활용할 변수 선언
    // 3.1 최소 비용 기록 배열
    int[] costArr = new int[N];
    Arrays.fill(costArr, Integer.MAX_VALUE);
    costArr[start] = 0;
    // 3.2 방문 순서 기록을 위한 우선 순위 큐(정점번호, 거리)
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    queue.add(new Node(start, 0));

    // 4. 다익스트라를 통해 최단 거리 구하기
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      // 기록된 거리가 최소 거리 이상이면 이미 방문한 것이므로 무시
      if (costArr[now.vertex] < now.cost) {
        continue;
      }
      // 현재 정점에서 연결된 간선 탐색
      for (Node next : graph[now.vertex]) {
        int costSum = costArr[now.vertex] + next.cost;
        // 현재 정점에서의 거리가 기록된 거리보다 작을 경우 거리 갱신하고 다음 정점 큐에 삽입
        if (costSum < costArr[next.vertex]) {
          costArr[next.vertex] = costSum;
          queue.add(new Node(next.vertex, costSum));
        }
      }
    }

    // 5. 정답 출력
    for (int cost : costArr) {
      sb.append(cost == Integer.MAX_VALUE ? "INF" : cost).append("\n");
    }
    System.out.println(sb.toString().trim());
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}