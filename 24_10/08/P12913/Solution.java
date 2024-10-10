import java.util.*;

class Solution {
    int solution(int[][] land) {
        // 1. 관련 변수 선언
        // 1.1 행의 개수
        int N = land.length;
        // 1.2 메모이제이션을 위한 이차원배열
        int[][] maxScores = new int[N][4];
        for (int i = 0; i < 4; i++) {
            maxScores[0][i] = land[0][i];
        }
        
        // 2. dp를 통해 각 칸별 최대 점수 환산
        // r: 행, c: 열, pr: 이전 행, pc: 이전 행의 열
        // 2.1 각 칸을 돌며 이전값으로부터의 최대값을 연산
        for (int r = 1; r < N; r++) {
            int pr = r - 1;
            for (int c = 0; c < 4; c++) {
                for (int pc = 0; pc < 4; pc++) {
                    // 이전 열과 같은 경우
                    if (c == pc) continue;
                    // 같지 않은 경우 최대값 기록
                    if (maxScores[r][c] < maxScores[pr][pc] + land[r][c]) {
                        maxScores[r][c] = maxScores[pr][pc] + land[r][c];
                    }
                }
            }
        }
        // 2.2 마지막 칸의 최대값 구하기
        int maxScore = 0;
        for (int score : maxScores[N-1]) maxScore = Math.max(maxScore, score);
        
        return maxScore;
    }
}