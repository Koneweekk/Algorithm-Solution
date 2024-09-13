import java.util.*;
import java.io.*;

public class Main {
  // 입출력 관련 필드
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();
  // 공통 변수 필드
  int rootNode = 0;
  Stack<Integer> nodeStack = new Stack<>(); // 노드 관계를 정리할 스택
  HashMap<Integer, int[]> binaryTree = new HashMap<>(); // 이진 트리

  // 응용 함수 - 후위 순회 재귀
  private void postorder(int node) {
    // 왼쪽 노드 출력
    if (binaryTree.get(node)[0] != 0) {
      postorder(binaryTree.get(node)[0]);
    }
    // 오른쪽 노드 출력
    if (binaryTree.get(node)[1] != 0) {
      postorder(binaryTree.get(node)[1]);
    }
    // 현재 노드 출력
    sb.append(node).append("\n");
  }

  // 응용 함수 - 트리 관계 정리
  private void connectNode(int node) {
    // 1. 노드 트리에 추가
    binaryTree.put(node, new int[2]);
    // 2. 루트 노드 기록
    if (rootNode == 0) {
      rootNode = node;
    }
    // 3. 스택이 비어있을 경우 연산 진행 X
    if (nodeStack.isEmpty()) {
      return;
    }
    // 4. 스택에서 이전 노드값보다 작다면 이전 노드의 왼쪽 자식으로 추가
    if (node < nodeStack.peek()) {
      binaryTree.get(nodeStack.peek())[0] = node;
      return;
    }
    // 5. 스택에서 이전 노드값보다 크다면 적절한 노드의 오른쪽 자식으로 추가
    if (node > nodeStack.peek()) {
      int parentNode = nodeStack.pop();
      // 적절한 부모 노드가 나올 때까지 스택에서 pop
      while (nodeStack.size() > 0 && node > nodeStack.peek()) {
        parentNode = nodeStack.pop();
      }
      // 부모 노드의 오른쪽 자식으로 추가
      binaryTree.get(parentNode)[1] = node;
    }
  }

  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값을 받으며 트리 정리
    String input;
    while ((input = br.readLine()) != null) {
      // 1.1 트리에 노드 추가
      int node = Integer.parseInt(input);
      // 1.2 트리 관계 정의
      connectNode(node);
      // 1.3 노드 스택에 노드 추가
      nodeStack.add(node);
    }

    // 2. 트리를 후위 순회한 후 결과 출력
    postorder(rootNode);
    System.out.println(sb.toString().trim());
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}