import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuffer sb = new StringBuffer();
  // 공통 변수 필드
  int[][] directions = { { 1, 2 }, { 2, 1 }, { -2, -1 }, { -1, -2 }, { 2, -1 }, { 1, -2 }, { -2, 1 }, { -1, 2 } };

  // 테스트 케이스 실행 함수
  private void solveTestCase() throws IOException {
    // 1. 입력값 변수에 할당
    int I = Integer.parseInt(br.readLine()); // 체스판 크기
    String[] input = br.readLine().split(" ");
    int[] start = { Integer.parseInt(input[0]), Integer.parseInt(input[1]) }; // 시작점
    input = br.readLine().split(" ");
    int[] end = { Integer.parseInt(input[0]), Integer.parseInt(input[1]) }; // 끝지점

    // 2. bfs를 통해 끝지점에 닿기 까지의 최소 횟수 세기
    // 2.1 bfs를 위한 변수선언
    Queue<int[]> locationQueue = new ArrayDeque<>(); // 위치 정보 큐
    Queue<Integer> countQueue = new ArrayDeque<>(); // 이동 횟수 큐
    boolean[][] isVisited = new boolean[I][I];  // 재방문을 막기 위한 이중 배열

    // 2.2 큐에 시작 위치 삽입 및 방문 표시
    locationQueue.add(start);
    countQueue.add(0);
    isVisited[start[0]][start[1]] = true;

    // 2.3 큐를 돌며 나이트 이동
    while (true) {
      int[] current = locationQueue.poll();
      int count = countQueue.poll();
      // 현재 위치가 도착 지점일 경우
      if (current[0] == end[0] && current[1] == end[1]) {
        sb.append(count).append("\n");
        break;
      }
      // 아니면 8방을 돌며 위치를 queue에 삽입
      for (int[] dir : directions) {
        int nr = current[0] + dir[0];
        int nc = current[1] + dir[1];
        // 다음 탐색할 칸이 범위 밖일 경우
        if (nr < 0 || nr >= I)
          continue;
        if (nc < 0 || nc >= I)
          continue;
        // 다음 탐색할 칸이 이미 방문한 경우
        if (isVisited[nr][nc])
          continue;
        // 모두 유효하면 큐에 삽입
        locationQueue.add(new int[] { nr, nc });
        countQueue.add(count + 1);
        isVisited[nr][nc] = true;
      }
    }

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