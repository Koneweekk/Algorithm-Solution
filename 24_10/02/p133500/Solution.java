import java.util.*;

public class Solution {
    public int solution(int n, int[][] lighthouse) {
        // 1. 연결 관계 표시
        // 1.1 연결관계 배열 초기화
        Set<Integer>[] graph = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new HashSet<>();
        }
        // 1.2 연결 관계 표시
        for (int[] connect : lighthouse) {
            graph[connect[0]].add(connect[1]);
            graph[connect[1]].add(connect[0]);
        }

        // 2. bfs에 사용할 변수 선언
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        boolean[] turnOn = new boolean[n + 1];
        // 2.1 엔드 노드 큐에 삽입
        for (int i = 0; i < n + 1; i++) {
            if (graph[i].size() == 1) {
                queue.add(i);
            }
        }

        // 3. bfs를 돌며 불을 밝혀야하는 등대 탐색
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // 3.1 이미 탐색한 노드이면 패스
            if (visited[node]) continue;
            // 3.2 불꺼진 노드인 경우
            if (!turnOn[node]) {
                // 엔드포인트가 아니면 다시 큐에 삽입
                if (graph[node].size() != 1) {
                    queue.add(node);
                    continue;
                }
                // 엔드포인트이면 다음 노드 불켜고 삽입
                
            }
            visited[node] = true;
            if (graph[node].size() != 1) {
                queue.add(node);
            }
            for (int next : graph[node]) {
                // 이미 방문 표시한 노드이면 패스
                if (visited[next]) continue;
                // 엔드포인트가 아니면 다시 큐에 삽입

            }
        }

        System.out.println(queue.toString());

        // // 4. 순환하는 구조 해결
        // for (int i = 0; i < n; i++) {
        // if (visited[i]) continue;
        // // 4.1 순환하는 시스템 해결을 위한 변수 설정
        // int cycleSize = 0;
        // queue.add(i);
        // visited[i] = true;
        // // 4.2 순환 시스템의 크기 구하기
        // while (!queue.isEmpty()) {
        // int node = queue.poll();
        // cycleSize++;
        // for (int next : graph[node]) {
        // if (visited[next]) continue;
        // queue.add(next);
        // visited[next] = true;
        // }
        // }
        // // 4.3 필요한 등대수 증가
        // count += Math.round(cycleSize/2);
        // }

        return 0;
    }
}