import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args)  throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 횟수
    int K = Integer.parseInt(br.readLine());  
    // 입력값 정리용 스택
    Stack<Integer> numStack = new Stack<>();  
    // 입력값 총합
    int total = 0;
    
    for (int i = 0; i < K; i++) {
      // 입력값
      int n = Integer.parseInt(br.readLine());

      // 0 이면 스택에서 숫자를 꺼낸 후 감산
      if (n == 0) {
        int minus = numStack.pop();
        total -= minus;
      // 그 외의 값은 스택에 넣은 후 합산
      } else {
        numStack.push(n);
        total += n;
      }
    }

    System.out.println(total);
  }
}