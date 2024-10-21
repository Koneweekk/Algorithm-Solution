import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 1. 가격표 정렬
        Arrays.sort(d);
        
        // 2. 낮은 가격의 신청금부터 합산
        int count = 0;
        for (int cost : d) {
            if (budget < cost) break;
            budget -= cost;
            count++;
        }
        
        return count;
    }
}