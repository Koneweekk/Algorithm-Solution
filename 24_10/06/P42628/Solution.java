import java.util.*;

class Solution {
  // 현재 큐의 peek가 이미 제거되었는지 판단
  private boolean existedPeek(PriorityQueue<Integer> queue, Map<Integer, Integer> numberCount) {
    if (queue.isEmpty() || !numberCount.keySet().contains(queue.peek())) {
      queue.clear();
      return false;
    }

    return true;
  }

  public int[] solution(String[] operations) {
    // 1. 이중 우선순위 큐를 위한 자료 구조 초기화
    // 1.1 최소힙, 최대힙 선언
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // 1.2 숫자 개수를 셀 맵 선언
    Map<Integer, Integer> numberCount = new HashMap<>();

    // 2. 입력어를 반복하며 명령어 실행
    for (String operation : operations) {
      String[] o = operation.split(" ");
      int n = Integer.parseInt(o[1]);

      // 2.1 삽입 명령어
      if (o[0].equals("I")) {
        numberCount.put(n, numberCount.getOrDefault(n, 0) + 1);
        minHeap.add(n);
        maxHeap.add(n);
        System.out.println(minHeap.toString());
        System.out.println(maxHeap.toString());
      }

      // 2.2 최대값 제거 명령어
      if (o[0].equals("D") && n == 1) {
        System.out.println(maxHeap.toString());
        if (existedPeek(maxHeap, numberCount)) {
          int d = maxHeap.poll();
          if (numberCount.get(d) == 1) {
            numberCount.remove(d);
          } else {
            numberCount.put(d, numberCount.get(n) - 1);
          }
        }
        System.out.println(numberCount.toString());
      }

      // 2.3 최솟값 제거 명령어
      if (o[0].equals("D") && n == -1) {
        System.out.println(minHeap.toString());
        if (existedPeek(minHeap, numberCount)) {
          int d = minHeap.poll();
          if (numberCount.get(d) == 1) {
            numberCount.remove(d);
          } else {
            numberCount.put(d, numberCount.get(n) - 1);
          }
        }
        System.out.println(numberCount.toString());
      }

      System.out.println();
    }

    // 3. 정답 반환
    int[] answer = new int[2];
    answer[0] = existedPeek(maxHeap, numberCount)? maxHeap.peek() : 0;
    answer[1] = existedPeek(minHeap, numberCount)? minHeap.peek() : 0;

    return answer;
  }
}