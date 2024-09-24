import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();
  StringTokenizer st;
  // 공통 변수
  int M; // 행 길이
  int N; // 열 길이
  int K; // 사각형 개수
  boolean[][] blockedArea; // 모눈종이 영역
  int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  // 빈 영역 체크 함수
  private int checkArea(int r, int c) {
    // 1. dfs를 위한 stack 초기화
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[] { r, c });
    blockedArea[r][c] = true;

    // 2. 영역을 순회하며 연결된 빈 영역 개수 세고 블록 처리
    int count = 1;
    while (!stack.isEmpty()) {
      // 2.1 현재 영역
      int[] now = stack.pop();
      // 2.2 사방으로 탐색
      for (int[] d : directions) {
        // 탐색할 영역의 좌표
        int nr = now[0] + d[0];
        int nc = now[1] + d[1];
        // 탐색할 영역의 좌표가 유효한지 확인
        if (nr < 0 || nr >= M || nc < 0 || nc >= N || blockedArea[nr][nc]) {
          continue;
        }
        // 유효한 좌표면 스택에 삽입하고 개수 증가
        stack.add(new int[] { nr, nc });
        blockedArea[nr][nc] = true;
        count++;
      }
    }

    return count;
  }

  private void run() throws IOException {
    // 1. 변수 입력 받기
    // 1.1 공통 변수
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    blockedArea = new boolean[M][N];
    // 1.2 사각형 정보
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      // 꼭지점 정보 입력받기
      int sc = Integer.parseInt(st.nextToken()); // 시작열
      int sr = Integer.parseInt(st.nextToken()); // 시작행
      int ec = Integer.parseInt(st.nextToken()); // 끝열
      int er = Integer.parseInt(st.nextToken()); // 끝행
      // 시작 꼭지점부터 끝 꼭짓점까지 모두 블록 처리하기
      for (int r = sr; r < er; r++) {
        for (int c = sc; c < ec; c++) {
          blockedArea[r][c] = true;
        }
      }
    }

    // 2. 영역을 순회하며 빈영역 체크
    int count = 0; // 총 영역 개수
    List<Integer> areaInfos = new ArrayList<>(); // 빈영역들의 정보
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < N; c++) {
        // 2.1 블록처리된 영역이면 패스
        if (blockedArea[r][c]) {
          continue;
        }
        // 2.2 그 외의 영역이면 연결된 모든 빈영역 체크
        count++;
        areaInfos.add(checkArea(r, c));
      }
    }

    // 3. 정답 출력
    // 3.1 영역 크기에 따라 정렬
    areaInfos.sort((a, b) -> a - b);
    for (int area : areaInfos) {
      sb.append(area).append(" ");
    }
    // 3.2 출력
    System.out.println(count);
    System.out.println(sb.toString().trim());
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}