import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuffer sb = new StringBuffer();
  StringTokenizer st;
  // 공통 변수 필드
  int N;
  int minHeight;  // 최소 높이
  int maxHeight;  // 최대 높이
  int[][] mapArray;  // 지도 배열
  int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };  // 이동 방향
  int w;  // 지도 가로 크기
  int h;  // 지도 세로 크기
  int count;  // 섬의 개수


  // 지도 순회 함수
  private void findIsland(int[] start) {
    // 1. dfs를 위한 스택 선언
    Stack<int[]> stack = new Stack<>();
    stack.add(start);
    mapArray[start[0]][start[1]] = 0;

    // 2. dfs를 통해 현재 위치와 인접한 육지 탐색
    while (!stack.isEmpty()) {
      int[] now = stack.pop();
      for (int[] dir : directions) {
        // 2.1 다음 진행 방향
        int nr = now[0] + dir[0];
        int nc = now[1] + dir[1];
        // 2.2 지도 밖을 벗어난 경우 다음 방향 탐색
        if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
        // 2.3 바다인 경우 다음 방향 탐색
        if (mapArray[nr][nc] == 0) continue;
        // 2.4 육지인 경우 스택에 넣고 지도에 표시
        stack.add(new int[]{nr, nc});
        mapArray[nr][nc] = 0;
      }
    }
  } 


  // 테스트 케이스 실행 함수
  private void solveTestCase() throws IOException {
    // 1. 지도값 할당
    mapArray = new int[h][w];
    for (int r = 0; r < h; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < w; c++) {
        mapArray[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    // 2. 지도를 순회하며 섬 개수 체크
    count = 0;
    for (int r = 0; r < h; r++) {
      for (int c = 0; c < w; c++) {
        // 2.1 바다인 경우 다음 위치 탐색
        if (mapArray[r][c] == 0) continue;
        // 2.2 섬인 경우 섬의 크기 탐색
        count++;
        findIsland(new int[]{r, c});
      }
    }

    // 3. 정답값 입력
    sb.append(count).append("\n");
  }


  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 할당
    // 1.1 지도 크기
    N = Integer.parseInt(br.readLine());
    // 1.2 위치당 높이 정보
    mapArray = new int[N][N];
    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        // 지도에 높이 정보 입력
        int height = Integer.parseInt(st.nextToken());
        mapArray[r][c] = height;
        // 최소 높이 최대 높이 갱신
        
      }
    }

    // 2. 지도를 순회하며 섬 개수 체크
    count = 0;
    for (int r = 0; r < h; r++) {
      for (int c = 0; c < w; c++) {
        // 2.1 바다인 경우 다음 위치 탐색
        if (mapArray[r][c] == 0) continue;
        // 2.2 섬인 경우 섬의 크기 탐색
        count++;
        findIsland(new int[]{r, c});
      }
    }
  }


  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}