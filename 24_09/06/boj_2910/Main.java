import java.io.*;
import java.util.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;
  // 공통 변수
  int N; // 숫자 개수
  int C; // 최대값
  // 응용 변수
  HashMap<Integer, Integer> frequencyMap = new HashMap<>(); // 빈도수 저장
  HashMap<Integer, Integer> orderMap = new HashMap<>(); // 순서 저장

  // 주요 실행 함수
  private void run() throws IOException {
    // 입력값 변수에 할당
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    // 각 숫자의 빈도와 순서 저장
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int number = Integer.parseInt(st.nextToken());
      // 처음 나오는 숫자인 경우
      if (!frequencyMap.containsKey(number)) {
        frequencyMap.put(number, 0);
        orderMap.put(number, i);
      }
      // 빈도수 증가
      frequencyMap.replace(number, frequencyMap.get(number) + 1);
    }

    // 빈도수와 순서에 따라 정렬
    List<Integer> numberList = new ArrayList<>(frequencyMap.keySet());
    numberList.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (frequencyMap.get(o1) == frequencyMap.get(o2)) {
          return orderMap.get(o1).compareTo(orderMap.get(o2));
        } else {
          return frequencyMap.get(o2).compareTo(frequencyMap.get(o1));
        }
      }
    });

    StringBuilder sb = new StringBuilder();
    for (Integer number : numberList) {
      for (int i = 0; i < frequencyMap.get(number); i++) {
        sb.append(number);
        sb.append(" ");
      }
    }

    System.out.println(sb.toString().trim());
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}