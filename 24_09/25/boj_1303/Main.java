import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  // 응용 변수 관련 필드
  int N;  // 가로 길이
  int M;  // 세로 길이
  String[][] mapArray;  // 병사들 위치 배열
  boolean[][] isVisited;  // 방문 기록 배열
  Map<String, Integer> powerMap;
  int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };  // 방향 배열

  // 위력 합산 함수
  private void sumPower(int r, int c) {
    // 1. 탐색을 위한 변수 준비
    // 1.1 dfs를 위한 stack 초기화
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[] {r,c});
    isVisited[r][c] = true;
    // 1.2 현재 위치의 색깔
    String color = mapArray[r][c];

    // 2. dfs로 순회하며 총 위력 산출
    int count = 1;
    while (!stack.isEmpty()) {
      // 2.1 탐색할 위치 stack에서 꺼내기
      int[] now = stack.pop();
      // 2.2 현재 위치에서 사방을 탐색
      for (int[] d : directions) {
        // 다음 탐색 좌표
        int nr = now[0] + d[0];
        int nc = now[1] + d[1];
        // 유효한 좌표인지 탐색
        if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
          continue;
        }
        // 이미 방문했거나 아군인지 탐색
        if (isVisited[nr][nc] || !mapArray[nr][nc].equals(color)) {
          continue;
        }
        // 유효한 좌표인 경우 병사수 증가 후 스택에 삽입
        count++;
        stack.add(new int[] {nr, nc});
        isVisited[nr][nc] = true;
      }
    }

    // 3. 병사 수를 통한 위력 산출
    powerMap.put(color, powerMap.get(color) + count * count);
  }


  private void run() throws IOException {
    // 1 입력값 변수에 할당
    // 1.1 지도 크기
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    // 1.2 관련 배열 초기화
    mapArray = new String[M][N];
    powerMap = new HashMap<>();
    powerMap.put("B", 0);
    powerMap.put("W", 0);
    // 1.3 병사들 위치 기록
    for (int r = 0; r < M; r++) {
      String[] nowRow = br.readLine().split("");
      for (int c = 0; c < N; c++) {
        mapArray[r][c] = nowRow[c];
      }
    }

    // 2 지도를 순회하며 각 군의 총 위력 합산
    isVisited = new boolean[M][N];
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < N; c++) {
        // 2.1 이미 탐색한 위치면 건너뜀
        if (isVisited[r][c]) {
          continue;
        }
        // 2.2 아닐 경우 탐색 진행
        sumPower(r, c);
      }
    }

    // 3 정답 출력
    System.out.println(powerMap.get("W") + " " + powerMap.get("B"));
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}