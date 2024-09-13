import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 높이 정보를 담을 스택([높이, 인덱스])
    Stack<int[]> heightStack = new Stack<>();
    // 정답 배열
    String[] answerArr = new String[N];

    // 타워들을 순회하며 정답 배열 추출
    for (int i = 0; i < N; i++) {
      int height = Integer.parseInt(st.nextToken());

      while (true) {
        // 현재 스택이 비어있다면 정답에 0을 넣고 스택에 현재 높이 삽입
        if (heightStack.isEmpty()) {
          answerArr[i] = String.valueOf(0);
          heightStack.push(new int[] {height, i + 1});
          break;
        }
        // 스택의 peek가 현재 높이보다 높은 경우
        else if (heightStack.peek()[0] > height) {
          answerArr[i] = String.valueOf(heightStack.peek()[1]);
          heightStack.push(new int[] {height, i + 1});
          break;
        } 
        // 현재 높이보다 높은 숫자가 나올 때까지 stack을 비움
        else {
          heightStack.pop();
        }
      }
    }
    
    System.out.println(String.join(" ", answerArr));
  }
}