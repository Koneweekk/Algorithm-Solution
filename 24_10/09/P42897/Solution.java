public class Solution {
  public int solution(int[] money) {
      // 1. 활용할 변수 정리
      // 1.1 집 개수
      int N = money.length;
      // 1.2 dp를 위한 배열
      int[] firstStart = new int[N-1];  // 첫번째 집 출발
      int[] secondStart = new int[N-1];  // 두번째 집 출발
      int[] thirdStart = new int[N-1];  // 세번째 집 출발
      // 1.3 dp 배열 초기 설정
      firstStart[0] = money[0];
      secondStart[0] = money[1];
      thirdStart[0] = money[2];
      if (N > 3) {
          firstStart[2] = money[0] + money[2];
          secondStart[2] = money[1] + money[3];
          thirdStart[2] = money[2] + money[4 % N];
      }
      
      // 2. 각 집을 순회하며 최대 훔칠 수 있는 돈 갱신
      for (int i = 3; i < N-1; i++) {
          // 첫번째 집 출발 배열 갱신
          firstStart[i] = money[i] + Math.max(firstStart[i-2], firstStart[i-3]);
          // 두번째 집 출발 배열 갱신
          secondStart[i] = money[i+1] + Math.max(secondStart[i-2], secondStart[i-3]);
          // 세번째 집 출발 배열 갱신
          thirdStart[i] = money[(i+2) % N] + Math.max(thirdStart[i-2], thirdStart[i-3]);
      }
      
      // 3. 최대값 구하기
      int answer = 0;
      answer = Math.max(answer, Math.max(firstStart[N-2], firstStart[N-3]));
      answer = Math.max(answer, Math.max(secondStart[N-2], secondStart[N-3]));
      answer = Math.max(answer, Math.max(thirdStart[N-2], thirdStart[N-3]));
      
      return answer;
  }
}