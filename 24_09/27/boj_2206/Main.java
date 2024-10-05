import java.util.*;
import java.io.*;

// 위치 관련 클래스
class Node {
  int row; // 행위치
  int col; // 열위치
  int depth;
  boolean power; // 벽 파괴 가능 여부

  public Node(int row, int col, int depth, boolean power) {
    this.row = row;
    this.col = col;
    this.depth = depth;
    this.power = power;
  }
}

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  private void run() throws IOException {
    // 1 입력값 변수에 할당
    // 1.1 지도 크기
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    // 1.2 지도 정보 기록
    int[][] mapArray = new int[N][M];
    for (int r = 0; r < N; r++) {
      String[] nowRow = br.readLine().split("");
      for (int c = 0; c < M; c++) {
        mapArray[r][c] = Integer.parseInt(nowRow[c]);
      }
    }

    // 2 bfs를 통해 변수 선언
    // 2.1 큐 생성
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0, 1, true));
    // 2.2 방문 여부 기록 배열
    boolean[][] powerVisited = new boolean[N][M];
    boolean[][] noPowerVisited = new boolean[N][M];
    powerVisited[0][0] = true;
    noPowerVisited[0][0] = true;

    // 3 bfs를 통해 최단경로 추출
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      // 3.1 도착한 경우
      if (now.row == N - 1 && now.col == M - 1) {
        System.out.println(now.depth);
        return;
      }
      // 3.2 사방 탐색
      for (int[] d : directions) {
        int nr = now.row + d[0];
        int nc = now.col + d[1];
        // 지도를 벗어난 좌표인 경우
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
          continue;
        }
        // 벽 파괴가 가능하고 이미 탐색한 경우
        if (now.power && powerVisited[nr][nc]) {
          continue;
        }
        // 벽파괴가 불가능하고 이미 탐색한 경우
        if (!now.power && noPowerVisited[nr][nc]) {
          continue;
        }
        // 벽을 부술 수 없는 경우
        if (mapArray[nr][nc] == 1 && !now.power) {
          continue;
        }
        // 다음 node 객체 삽입
        boolean nextPower = mapArray[nr][nc] == 0 && now.power;
        queue.add(new Node(nr, nc, now.depth + 1, nextPower));
        if (nextPower) {
          powerVisited[nr][nc] = true;
        } else {
          noPowerVisited[nr][nc] = true;
        }
      }
    }

    System.out.println(-1);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}