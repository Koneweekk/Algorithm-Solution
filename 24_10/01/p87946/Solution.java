import java.util.*;

class Search {
    Set<Integer> remains;
    int count;
    int power;
    
    Search(Set<Integer> remains, int count, int power) {
        this.remains = remains;
        this.count = count;
        this.power = power;
    }
}

public class Solution {
    public int solution(int k, int[][] dungeons) {
        // 1. 관련 변수 정리
        // 1.1 던전 개수와 최대 방문 가능 개수
        int dungeonsCount = dungeons.length;
        int maxCount = 0;
        // 1.2 탐색 위한 Stack (피로도, 탐색 순서, 현재까지 방문 개수)
        Stack<Search> stack = new Stack<>();
        Set<Integer> fullRemains = new HashSet<>();
        for (int i = 0; i < dungeonsCount; i ++) {
            fullRemains.add(i);
        }
        stack.add(new Search(fullRemains, 0, k));
        
        // 2 dfs를 통해 던전들 탐색
        while (!stack.isEmpty()) {
            Search now = stack.pop();
            System.out.print(now.count + " ");
            System.out.print(now.power + " ");
            System.out.print(now.remains.toString());
            System.out.println();
            // 2.1 모든 방을 다 탐색한 경우
            if (now.remains.size() == 0) {
                maxCount = now.count > maxCount ? now.count : maxCount;
                continue;
            }
            // 2.2 그 외의 경우 나머지방 탐색
            for (int next : now.remains) {
                // 2.1 남은 피로도가 부족한 경우
                if (now.power < dungeons[next][0]) {
                    continue;
                }
                // 2.2 그 외의 경우 탐색
                Set<Integer> remains = new HashSet<>(now.remains);
                remains.remove(next);
                stack.add(new Search(remains, now.count + 1, now.power - dungeons[next][1]));
            }
        }
        
        return maxCount;
    }
}