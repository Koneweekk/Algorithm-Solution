import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 활용할 변수 정리
        // 1.1 크기별 귤 개수를 정리할 맵
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int t : tangerine) {
            countMap.put(t, countMap.containsKey(t) ? countMap.get(t) + 1 : 1);
        }
        // 1.2 존재하는 귤 크기 배열
        List<Integer> sizeList = new ArrayList<>(countMap.keySet());
        // 1.3 귤 크기 배열을 개수를 기준으로 정렬
        sizeList.sort((o1, o2) -> countMap.get(o2) - countMap.get(o1));
        
        // 2. 개수가 많은 크기부터 상자에 넣기
        int count = 0;
        for (int size : sizeList) {
            k -= countMap.get(size);
            count++;
            if (k <= 0) break;
        }
        
        
        return count;
    }
}