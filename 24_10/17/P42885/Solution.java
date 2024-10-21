import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 몸무게 정렬
        Arrays.sort(people);
        // 현재까지 구출한 사람 인덱스(가벼운 사람부터, 무거운 사람부터)
        int left = 0, right = people.length - 1;
        
        // 보트 개수 구하기
        int count = 0;
        while (left <= right) {
            // 무거운 사람은 일단 태운다고 가정
            int remain = limit - people[right--];
            // 남은 무게를 보고 왼쪽 사람 태우기
            if (people[left] <= remain) left++;
            // 보트 개수 증가    
            count++;
        }

        return count;
    }
}