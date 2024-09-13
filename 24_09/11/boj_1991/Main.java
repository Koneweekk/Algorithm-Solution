import java.util.*;
import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int N; // 노드 개수
  HashMap<String, String[]> binaryTree = new HashMap<>(); // 이진 트리
  StringBuilder sb;

  // 전위 순회 재귀 함수
  private void preorder(String node) {
    // 현재 노드 출력
    sb.append(node);
    // 왼쪽 노드 출력
    if (!binaryTree.get(node)[0].equals(".")) {
      preorder(binaryTree.get(node)[0]);
    }
    // 오른쪽 노드 출력
    if (!binaryTree.get(node)[1].equals(".")) {
      preorder(binaryTree.get(node)[1]);
    }
  }

  // 중위 순회 재귀 함수
  private void inorder(String node) {
    // 왼쪽 노드 출력
    if (!binaryTree.get(node)[0].equals(".")) {
      inorder(binaryTree.get(node)[0]);
    }
    // 현재 노드 출력
    sb.append(node);
    // 오른쪽 노드 출력
    if (!binaryTree.get(node)[1].equals(".")) {
      inorder(binaryTree.get(node)[1]);
    }
  }

  // 후위 순회 재귀 함수
  private void postorder(String node) {
    // 왼쪽 노드 출력
    if (!binaryTree.get(node)[0].equals(".")) {
      postorder(binaryTree.get(node)[0]);
    }
    // 오른쪽 노드 출력
    if (!binaryTree.get(node)[1].equals(".")) {
      postorder(binaryTree.get(node)[1]);
    }
    // 현재 노드 출력
    sb.append(node);
  }

  // 주요 실행 함수
  private void run() throws IOException {
    // 1. 입력값 변수에 할당
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] nodeConnect = br.readLine().split(" ");
      binaryTree.put(nodeConnect[0], new String[] { nodeConnect[1], nodeConnect[2] });
    }

    // 2. 3가지 순회 출력
    // 2.1 전위 순회
    sb = new StringBuilder();
    preorder("A");
    System.out.println(sb.toString());
    // 2.2 전위 순회
    sb = new StringBuilder();
    inorder("A");
    System.out.println(sb.toString());
    // 2.3 후위 순회
    sb = new StringBuilder();
    postorder("A");
    System.out.println(sb.toString());
  }

  // 메인 함수
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.run();
  }
}