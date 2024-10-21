import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        // 1. 활용할 변수 모음
        // 1.1 단어 길이
        int N = t.length();
        // 1.2 단어 조각 검색을 편하게 하기 위한 SET(단어를 뒤집어 넣기)
        Set<String> strSet = new HashSet<>();
        for (String str : strs) {
            strSet.add(str);
        }
        // 1.3 부분 단어별 최소 조각 수 배열
        int[] minCount = new int[N];
        for (int i = 0; i < N; i++) {
            minCount[i] = 20001;
        }

        // 2. dp를 통해 부분 단어를 만들 수 있는 최소 조각 수 연산
        for (int i = 0; i < N; i++) {
            int maxIdx = Math.min(N, i + 5);
            for (int j = i; j < maxIdx; j++) {
                if (!strSet.contains(t.substring(i, j + 1))) continue;
                minCount[j] = i == 0 ? 1 : Math.min(minCount[j], minCount[i-1] + 1);
            }
        }
            
        return minCount[N-1] > 20000 ? -1 : minCount[N-1];
    }
}