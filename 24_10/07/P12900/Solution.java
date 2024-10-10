public class Solution {
  public int solution(int n) {
      // 1. 메모이제이션을 위한 배열 선언
      int[] memo = new int[n];
      // 1.1 첫째칸과 둘째칸 초기화(각 칸은 해당 칸까지 채울 경우의 수)
      memo[0] = 1;
      memo[1] = 2;
      
      // 2. 각 칸을 순회하며 각 칸의 경우의 수 연산
      for (int i = 0; i < n; i++) {
          memo[i] = (memo[i-2] + memo[i-1]) % 1000000007;
      }
      
      // 3. 마지막 칸의 경우의 수 반환
      return memo[n-1];
  }
}