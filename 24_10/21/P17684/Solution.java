import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        // 1. 활용할 변수 정리
        // 1.1 글자 길이
        int N = msg.length();
        // 1.2 메시지를 배열로 정리
        String[] msgArr = msg.split("");
        // 1.3 우선 알파벳들 사전에 넣기
        Map<String, Integer> dict = new HashMap<>();
        char currentChar = 'A';
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf(currentChar), i);
            currentChar++;
        }
        
        // 2. 각 글자별 사전번호 찾기
        // 2.1 관련 변수 선언
        int idx = 0;  // 현재 탐색 중인 글자의 인덱스
        int dictNum = 27;  // 다음 들어갈 사전 번호
        List<Integer> answer = new ArrayList<>();  // 정답 배열
        // 2.2 글자들 탐색
        while (idx < N) {
            // 사전에 없는 조합이 나올 때까지 글자를 늘려감
            int end = idx + 2;
            while (end <= N && dict.containsKey(msg.substring(idx, end))) {
                end++;
            }
            // 사전에 삽입
            if (end <= N) {
                dict.put(msg.substring(idx, end), dictNum++);
            }
            // 사전 번호 도출
            answer.add(dict.get(msg.substring(idx, --end)));
            // 다음 탐색할 글자 업데이트
            idx = end;
        }
        
        return answer;
    }
}