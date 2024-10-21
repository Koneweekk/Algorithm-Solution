import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 1. 활용할 변수 정리
        // 1.1 prices의 길이
        int N = prices.length;
        // 1.2 스택 선언([숫자, 인덱스])
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {prices[0], 0});
        
        // 2. 스택을 통해서 가격이 떨어지지 않은 기간 구하기
        int[] answer = new int[N];
        for (int idx = 1; idx < N; idx++) {
            // 2.1 현재 탐색 중인 주식가격보다 큰 가격이 스택에 존재한다면 모두 꺼내기
            while (!stack.isEmpty() && stack.peek()[0] > prices[idx]) {
                int[] priceInfo = stack.pop();
                answer[priceInfo[1]] = idx - priceInfo[1];
            }
            // 2.2 스택에 현재 주식 가격 삽입
            stack.add(new int[] {prices[idx], idx});
        }
        
        // 3. 스택에 남아있는 값 정리
        while (!stack.isEmpty()) {
            int[] priceInfo = stack.pop();
            answer[priceInfo[1]] = N - 1 - priceInfo[1];
        }
        
        return answer;
    }
}