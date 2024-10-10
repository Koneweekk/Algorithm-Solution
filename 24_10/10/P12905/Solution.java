import java.util.*;

public class Solution {
    public int solution(int[][] board) {
        // 1. 활용 변수 정리
        // 1.1 행, 열의 길이
        int N = board.length;
        int M = board[0].length;
        
        // 2. dp를 통해 각 좌표가 가지는 레벨 연산
        // 레벨 : 해당 좌표가 직사각형의 우측하단 꼭지점일 때 해당 직사각형의 최소변 길이
        int maxLen = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 2.1 사각형이 아닌 경우 패스
                if (board[r][c] == 0) continue;
                // 2.2 행과 열이 0이 아닌 경우
                if (r != 0 && c != 0) {
                    // 대각선, 좌측, 상측 확인 후 좌표의 레벨 갱신
                    int level = Math.min(Math.min(board[r-1][c], board[r][c-1]), board[r-1][c-1]);
                    board[r][c] += level;
                }
                // 2.3 최대 길이 갱신
                maxLen = Math.max(maxLen, board[r][c]);
            }
        }

        System.out.println(" ");
        for (int r = 0; r < N; r++) {
            System.out.println(Arrays.toString(board[r]));
        }

        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] board = new int[][] {{1,1,1,1},{1,1,0,1},{1,1,1,1},{1,1,1,1}};
        int[][] board = new int[][] {{0}};
        // int[][] board = new int[][] {{0,0,0,1,1}, {0,0,0,1,1}, {1,1,1,1,0}, {1,1,1,1,0}, {1,1,1,1,0}, {1,1,1,1,0}};
        System.out.println(solution.solution(board));
      }
}
