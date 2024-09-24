import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuffer sb = new StringBuffer();
  StringTokenizer st;
  // 공통 변수 필드
  int N;
  int[][] mapArray; // 지도 배열
  int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 이동 방향

  // 안전지대 개수 체크 함수
  private int findSafeArea(int height) {
    // 1. 관련 변수 선언
    boolean[][] isVisited = new boolean[N][N];  // 방문 표시 배열
    int count = 0;  // 안전지대 개수

    // 2. mapArray를 순회하며 안전지대 개수 체크
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {

        // 2.1 이미 탐색한 위치면 다음 위치 탐색
        if (isVisited[r][c]) {
          continue;
        }

        // 2.2 물에 잠기는 높이면 방문 표시 후 다음 위치 탐색
        if (mapArray[r][c] <= height) {
          isVisited[r][c] = true;
          continue;
        }

        // 2.3 dfs를 위한 스택 선언
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r, c});
        isVisited[r][c] = true;
        count++;

        // 2.4 dfs를 통해 현재 위치와 인접한 안전지대 탐색
        while (!stack.isEmpty()) {
          int[] now = stack.pop();
          for (int[] dir : directions) {
            // 다음 진행 방향
            int nr = now[0] + dir[0];
            int nc = now[1] + dir[1];
            // 지도 밖을 벗어난 경우
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
              continue;
            }
            // 이미 탐색한 지대인 경우
            if (isVisited[nr][nc]) {
              continue;
            }
            // 물에 잠기는 높이인 경우
            if (mapArray[nr][nc] <= height) {
              isVisited[r][c] = true;
              continue;
            }
            // 안전지대인 경우 스택에 넣고 지도에 표시
            stack.add(new int[] { nr, nc });
            isVisited[nr][nc] = true;
          }
        }
      }
    }

    // 3. 안전지대 개수 반환
    return count;
  }


  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 할당
    // 1.1 지도 크기
    N = Integer.parseInt(br.readLine());
    // 1.2 최대 높이
    int maxHeight = 0; // 최대 높이
    // 1.3 위치당 높이 정보
    mapArray = new int[N][N];
    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        // 지도에 높이 정보 입력
        int height = Integer.parseInt(st.nextToken());
        mapArray[r][c] = height;
        // 최대 높이 갱신
        if (height > maxHeight)
          maxHeight = height;
      }
    }

    // 2. 높이별로 안전지대 갯수 체크
    int maxCount = 0;
    for (int height = 0; height < maxHeight; height++) {
      // 2.1 현재 높이에서의 안전지대 개수 체크
      int count = findSafeArea(height);
      // 2.2 최고 개수 갱신
      if (count > maxCount) {
        maxCount = count;
      }
    }

    System.out.println(maxCount);
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}