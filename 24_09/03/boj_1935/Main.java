import java.io.*;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 피연산자의 개수
    int N = Integer.parseInt(br.readLine());
    // 후위 표기식
    String calcStr = br.readLine();
    // 피연산자 배열
    int[] numberArr = new int[N];
    for (int i = 0; i < N; i++) {
      numberArr[i] = Integer.parseInt(br.readLine());
    }
    // 후위 표기식을 계산할 스택
    Stack<Double> calcStack = new Stack<>();

    for (int i = 0; i < calcStr.length(); i++) {
      char charCode = calcStr.charAt(i);
      // 알파벳일 경우 숫자 스택에 삽입
      if (charCode >= 65) {
        calcStack.push((double)numberArr[charCode - 65]);
        continue;
      }
      // 연산 기호일 경우 스택에서 숫자를 꺼내 연산 진행
      double second = calcStack.pop();
      double first = calcStack.pop();
      if (charCode == 43) {  // 더하기
        calcStack.push(first + second);
      } 
      else if (charCode == 45) {  // 빼기
        calcStack.push(first - second);
      }
      else if (charCode == 42) {  // 곱하기
        calcStack.push(first * second);
      }
      else if (charCode == 47) {  // 나누기
        calcStack.push(first / second);
      }
    }

    // 소숫점 둘째 자리까지 출력(그 아래는 버림)
    System.out.println(String.format("%.2f", Math.floor(calcStack.pop()*100)/100));
  }
}
