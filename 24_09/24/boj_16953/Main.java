import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void run() throws IOException {
    // 1. 입력값 변수에 할당
    StringTokenizer st = new StringTokenizer(br.readLine());
    long start = Long.parseLong(st.nextToken());
    long end = Long.parseLong(st.nextToken());

    // 2. bfs를 통해 최소횟수 세기
    // 2.1 bfs를 위한 큐 초기화(숫자, 연산횟수)
    Queue<Long> numberQueue = new ArrayDeque<>();
    Queue<Long> countQueue = new ArrayDeque<>();
    numberQueue.add(start);
    countQueue.add(1L);
    // 2.2 bfs를 통해 연산진행
    while (!numberQueue.isEmpty()) {
      long n = numberQueue.poll();  // 현재 연산 중인 숫자
      long count = countQueue.poll();  // 현재 연산 중인 숫자
      for (long next : new long[] { n*2, n*10 + 1}) {
        // 목표 숫자에 도달한 경우
        if (next == end) {
          System.out.println(count + 1);
          return;
        }
        // 목표 숫자에 도달하지 못한 경우 
        if (next < end) {
          numberQueue.add(next);
          countQueue.add(count + 1);
        }
      }
    }
    // 2.3 도달할 경우의 수가 없는 경우
    System.out.println(-1);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}