public class Solution {
  int[][] answer;
  int idx;
  
  public int[][] solution(int n) {
      // 1. 변수 초기화
      answer = new int[(int) Math.pow(2, n) - 1][2];
      idx = 0;
      // 2. 하노이 재귀 함수를 통해 연산 진행
      hanoi(1, 2, 3, n);
          
      return answer;
  }
  
  private void hanoi(int start, int middle, int target, int height) {
      if (height == 0) return;
      // 맨아래 원판을 제외하고 중간 지점으로 옮김
      hanoi(start, target, middle, height - 1);
      // 맨아래 원판을 도착 지점으로 옮김
      answer[idx++] = new int[] {start, target};
      // 중간지점에 옮겨놨던 원판을 도착지점으로 옮김
      hanoi(middle, start, target, height - 1);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(" ");
    for (int[] part : solution.solution(4)) {
      System.out.println(part[0] + " " + part[1]);
    }
  }
}