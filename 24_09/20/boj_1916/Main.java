import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 변수 할당
    int N = Integer.parseInt(br.readLine());  // 도시 개수
    int M = Integer.parseInt(br.readLine());  // 버스 개수

    // 2. 버스 비용 배열 산출
    // 2.1 초기 배열 선언
    int[][] costMap = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(costMap[i], 1000000000);
    }
    // 2.2 버스 비용 입력 받고 기록
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      int cost = Integer.parseInt(st.nextToken());
      if (cost < costMap[start][end]) {
        costMap[start][end] = cost;
      }
    }

    // 3. 출발지와 도착지 기록
    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken()) - 1;
    int end = Integer.parseInt(st.nextToken()) - 1;

    // 4. 다익스트라에서 활용할 변수 선언
    boolean[] isVisited = new boolean[N];  // 방문 표시
    int visitCount = 0; // 방문 표시된 도시 개수
    int[] minCostArr = new int[N];  // 최소 비용 기록
    Arrays.fill(minCostArr, 1000000000);
    minCostArr[start] = 0;

    // 5. 다익스트라를 통해 최소 비용 산출
    while (visitCount < N) {
      // 5.1 초기 세팅
      isVisited[start] = true;  // 현재 탐색 도시 방문 표시
      visitCount++;  // 방문 도시 증가
      int currentMinCost = 1000000000;  // 다음 탐색할 도시를 위한 최소 비용 기록
      // 5.2 최소 비용 갱신 및 다음 탐색할 도시 선정
      int next = start;
      for (int i = 0; i < N; i++) {
        // 총 비용이 현재 기록된 최소 비용보다 작은 경우 연산 진행
        int costSum = minCostArr[start] + costMap[start][i];
        if ( costSum < minCostArr[i]) {
          minCostArr[i] = costSum;
        }
        // 다음 탐색할 도시 선정
        if (!isVisited[i] && minCostArr[i] < currentMinCost) {
          currentMinCost = minCostArr[i];
          next = i;
        }
      }
      // 5.3 다음 탐색할 도시 갱신
      start = next;
    }

    // 6. 정답 출력
    System.out.println(minCostArr[end]);
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}