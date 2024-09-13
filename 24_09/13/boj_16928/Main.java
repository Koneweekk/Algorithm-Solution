import java.util.*;
import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 변수에 할당
    // 1.1 사다리와 뱀의 개수
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 1.2 사다리와 뱀을 통한 워프 정보
    int[] warpInfo = new int[101];
    // 우선 자기 자신의 칸을 입력
    for (int i = 0; i < 101; i++) {
      warpInfo[i] = i;
    }
    // 사다리와 뱀의 출발지에 해당하는 칸엔 워프할 칸 입력
    for (int i = 0; i < N + M; i++) {
      String[] input = br.readLine().split(" ");
      warpInfo[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
    }

    // 2. 출발지까지의 최소 횟수 구하기
    // 2.1 활용할 자료구조 선언
    Queue<Integer> locQueue = new ArrayDeque<>(); 
    Queue<Integer> countQueue = new ArrayDeque<>(); 
    boolean[] isVisited = new boolean[101];

    // 2.2 출발 위치 세팅
    locQueue.add(1);
    countQueue.add(0);
    isVisited[1] = true;

    // 2.3 보드판 이동
    while (true) {
      int loc = locQueue.poll();
      int count = countQueue.poll();
      // 주사위 눈금 개수별로 이동시켜봄
      for (int i = 1; i <= 6; i++) {
        // 도착한 경우 정답 출력 후 종료
        if (loc + i == 100) {
          System.out.println(count + 1);
          return;
        }
        // 아닌 경우 맵 따라 이동
        int newLoc = warpInfo[loc + i];
        // 이미 방문한 위치가 아닐 경우 큐에 삽입
        if (!isVisited[newLoc]) {
          locQueue.add(newLoc);
          countQueue.add(count + 1);
          isVisited[newLoc] = true;
        };
      }
    }
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}