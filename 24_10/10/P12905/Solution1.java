import java.util.*;

public class Solution1 {
    int maxLen = 0;
    
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
        // 2.1 활용할 변수 정리
        int maxLen = 0;  // 현재까지 구한 정사각형 최대 변의길이
        boolean[][] visited = new boolean[N][M];  // 방문 표시
        Stack<int[]> stack = new Stack<>();
        
        // 2.2 board를 순회하며 사각형 넓이 구하기
        for (int c = M - 1; c >= 0; c--) {
            for (int r = 0; r < N; r++) {
                // 사각형이 아니거나 방문 표시를 한 경우
                if (board[r][c] == 0 || visited[r][c]) continue;
                
                // 사각형이 맞으면 현재 좌표를 스택에 넣고 연산 진행
                // [탐색 행, 탐색 열, 현재까지의 가로 길이, 현재까지의 세로 길이]
                stack.add(new int[] {r, c, board[r][c], 1});
                
                // while을 통해 더이상 탐색 불가능할 때까지 연산
                while (!stack.isEmpty()) {
                    int[] now = stack.pop();
                    if (maxLen >= now[2]) continue;
                    // 방문 표시
                    visited[now[0]][now[1]] = true;
                    // 정사각형 최대 크기 갱신
                    maxLen = Math.max(maxLen, Math.min(now[2], now[3]));
                    if (now[2] == now[3]) continue;
                    // 다음 행이 표를 벗어나거나 사각형이 아닌 경우 탈출
                    int nr = now[0] + 1;
                    if (nr == N || board[nr][c] == 0) continue;
                    // 다음 행의 가로 길이가 켜지는 경우 새로 사각형 넓이를 구함
                    if (board[nr][c] > now[2]) {
                        stack.add(new int[] {nr, now[1], board[nr][c], 1});
                    }
                    // 다음 행 그대로 탐색
                    stack.add(new int[] {nr, now[1], Math.min(now[2], board[nr][c]), now[3] + 1});
                }
            }
        }

            
        return maxLen * maxLen;
    }
}