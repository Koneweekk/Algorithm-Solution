import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuffer sb = new StringBuffer();
  // 공통 변수 필드
  int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


  // 테스트 케이스 실행 함수
  private void solveTestCase() throws IOException {

    // 1. 입력값 변수에 할당
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1.1 밭 정보 입력
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    boolean[][] isNeeded = new boolean[N][M];
    // 1.2 배추 위치 기록
    for (int i = 0; i < K; i++) {
      String[] loc = br.readLine().split(" ");
      isNeeded[Integer.parseInt(loc[0])][Integer.parseInt(loc[1])] = true;
    }

    // 2. 밭을 순회하며 필요한 지렁이 개수 세기
    int count = 0;
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        // 2.1 지렁이가 필요하지 않은 땅이면 다음 구획 탐색
        if (!isNeeded[r][c]) continue;
        // 2.2 dfs를 위한 stack 선언
        count++;  // 필요한 개수 증가
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r, c});
        // 2.3 dfs를 활용하여 인접한 땅들 탐색
        while(!stack.isEmpty()) {
          // 현재 탐색 중인 땅
          int[] current = stack.pop();
          // 그 인접의 땅들 탐색
          for (int[] dir : directions) {
            int nr = current[0] + dir[0];
            int nc = current[1] + dir[1];
            // 다음 탐색할 땅이 범위 밖일 경우
            if (nr < 0 || nr >= N) continue;
            if (nc < 0 || nc >= M) continue;
            // 다음 탐색할 땅이 지렁이가 필요없는 경우
            if (!isNeeded[nr][nc]) continue;
            // 모두 유효하면 stack에 삽입
            stack.add(new int[]{nr, nc});
            isNeeded[nr][nc] = false;
          }
        }
      }
    }

    // 3. 정답 기록
    sb.append(count).append("\n");
  }


  // 주요 실행 함수
  private void run() throws IOException {
    // 테스트 케이스 수행
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      solveTestCase();
    }

    // 정답 출력
    System.out.println(sb.toString().trim());
  }


  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}