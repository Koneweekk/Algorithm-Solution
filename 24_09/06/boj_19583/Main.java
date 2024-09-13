import java.io.*;
import java.util.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;
  // 공통 변수
  int S; // 시작 시간
  int E; // 개강 총회 종료시간
  int Q; // 스트리밍 종료 시간
  // 응용 변수
  HashSet<String> attendMap = new HashSet<>();

  // 시간 문자열 정수로 변환
  private int timeConvert(String timeStr) {
    String[] timeArr = timeStr.split(":");
    return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
  }

  // 주요 실행 함수
  private void run() throws IOException {
    // 입력값 할당
    st = new StringTokenizer(br.readLine());
    S = timeConvert(st.nextToken());
    E = timeConvert(st.nextToken());
    Q = timeConvert(st.nextToken());

    // 스트리밍 방 입장과 퇴장 기록
    int count = 0;  // 정상 입퇴장한 사람 수
    String input;
    while ((input = br.readLine()) != null) {
      st = new StringTokenizer(input);
      int time = timeConvert(st.nextToken());
      String name = st.nextToken();

      // 시작 시간 이전이고, 입장 기록이 없는 경우
      if (time <= S && !attendMap.contains(name)) {
        attendMap.add(name);
      }
      // 유효한 퇴장 시간이고, 이전에 입장 기록이 있는 경우
      else if (time >= E && time <= Q && attendMap.contains(name)) {
        attendMap.remove(name);
        count++;
      }
    }

    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}