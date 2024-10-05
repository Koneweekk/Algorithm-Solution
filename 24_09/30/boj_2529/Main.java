import java.util.*;
import java.io.*;


class ChainedInequality {
  String numbers;
  Set<Integer> remains;
  int previous;
  int order;

  ChainedInequality(String numbers, Set<Integer> remains, int previous, int order) {
    this.numbers = numbers;
    this.remains = remains;
    this.previous = previous;
    this.order = order;
  }
}


public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  private void run() throws IOException {
    // 1 입력값 변수에 할당
    // 1.1 부등호 개수
    int k = Integer.parseInt(br.readLine());
    // 1.2 괄호 배열
    String[] brackets = br.readLine().split(" ");

    // 2. dfs 탐색을 위한 관련 변수 선언
    // 2.1 dfs를 위한 스택 선언
    Stack<ChainedInequality> stack = new Stack<>();
    for (int i = 0; i < 10; i++) {
      // 남아있는 수
      Set<Integer> remains = new HashSet<>();
      for (int j = 0; j < 10; j++) {
        remains.add(j);
      }
      remains.remove(i);
      // 현재 삽입된 수
      int[] numbers = new int[k + 1];
      numbers[0] = i;
      // 스택에 초기값 삽입
      stack.add(new ChainedInequality(String.valueOf(i), remains, i, 0));
    }
    // 2.2 최대값 최소값
    String max = "01";
    String min = "9876543210";

    // 3. dfs를 돌며 최대값 최소값 탐색
    while (!stack.isEmpty()) {
      ChainedInequality ci = stack.pop();
      // 3.1 백트래킹 통과
      if (ci.order == k) {
        // 최대값 갱신
        if (Long.parseLong(ci.numbers) > Long.parseLong(max)) {
          max = ci.numbers;
        }
        // 최소값 갱신
        if (Long.parseLong(ci.numbers) < Long.parseLong(min)) {
          min = ci.numbers;
        }
        continue;
      }
      // 3.2 부등호식 판별
      for (int n : ci.remains) {
        // 부등호 판단
        if (brackets[ci.order].equals(">") && ci.previous < n) {
          continue;
        }
        if (brackets[ci.order].equals("<") && ci.previous > n) {
          continue;
        }
        // 남은 수 정리
        Set<Integer> remains = new HashSet<>(ci.remains);
        remains.remove(n);
        // 스택에 삽입
        stack.add(new ChainedInequality(ci.numbers + n, remains, n, ci.order + 1));
      }
    }

    // 4. 정답출력
    System.out.println(max);
    System.out.println(min);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}