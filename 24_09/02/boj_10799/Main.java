import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args)  throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] bracketArr = br.readLine().split("");

    int overlapCount = 0;  // 현재 겹쳐져있는 막대 개수
    int idx = 0;  // 괄호 배열에서 현재 탐색 중인 인덱스
    int answer = 0;  // 잘려진 총 부분의 개수
    while (idx < bracketArr.length) {
      // 막대의 끝인 경우
      if (bracketArr[idx].equals(")")) {
        answer += 1;
        overlapCount--;
      } else {
        // 레이저인 경우
        if (bracketArr[idx + 1].equals(")")) {
          answer += overlapCount;
          idx++;
        }
        // 막대의 시작인 경우
        else {
          overlapCount++;
        }
      }
      idx++;
    }

    System.out.println(answer);
  }
}