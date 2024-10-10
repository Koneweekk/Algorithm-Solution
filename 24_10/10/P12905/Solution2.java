import java.util.*;

public class Solution2 {
    public int solution(int[][] board) {
        // 1. 활용 변수 정리
        // 1.1 행, 열의 길이
        int N = board.length;
        int M = board[0].length;
        // 1.2 해당 좌표를 가장 오른쪽으로 했을 때 가질 수 있는 변의 길이
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < M; c++) {
                if (board[r][c] == 0) continue;
                board[r][c] += board[r][c-1];
            }
        }
        
        // 2. 정사각형들의 넓이 구하기
        int maxLen = 0;  // 현재까지 구한 정사각형 최대 변의길이
        for (int c = M - 1; c >= 0; c--) {
            int minW = 1000;  // 현재 탐색 중인 사각형의 가로 길이
            int maxH = 0;  // 현재 탐색 중인 사각형의 가로 길이
            for (int r = 0; r < N; r++) {
                // 사각형이 없는 칸의 경우
                if (board[r][c] == 0) {
                    minW = 1000;
                    maxH = 0;
                    continue;
                } 
                // 아닌 경우 현재까지 탐색한 변의 길이들 갱신
                minW = Math.min(board[r][c], minW);
                maxH++;
                // maxLen 갱신
                maxLen = Math.max(maxLen, Math.min(minW, maxH));
            }
        }
        
        System.out.println(" ");
        for (int r = 0; r < N; r++) {
            System.out.println(Arrays.toString(board[r]));
        }
            
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
      Solution2 solution = new Solution2();
      // int[][] board = new int[][] {{1,1,1,1},{1,1,0,1},{1,1,1,1},{1,1,1,1}};
      // int[][] board = new int[][] {{1,1,0,1}, {1,0,1,1}};
      int[][] board = new int[][] {{0,0,0,1,1}, {0,0,0,1,1}, {1,1,1,1,0}, {1,1,1,1,0}, {1,1,1,1,0}, {1,1,1,1,0}};
      System.out.println(solution.solution(board));
    }
}