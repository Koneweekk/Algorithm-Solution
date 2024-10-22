class Solution {
    public int solution(String dirs) {
        // 1. 지나온 길을 표시하기 위한 이중 배열
        // 1.1 새로 이동 표시
        boolean[][] vVisited = new boolean[10][11];
        // 1.2 가로 이동 표시
        boolean[][] hVisited = new boolean[11][10];
        
        // 2. 주어진 방향대로 이동
        // 2.1 활용할 변수 선언
        String[] dirsArr = dirs.split("");  // 방향 배열로 전환
        int count = 0;  // 새로 걸은 길의 개수
        int r = 0, c = 0;  // 현재 위치
        // 2.2 방향대로 이동
        for (String d : dirsArr) {
            // 위로 이동
            if (d.equals("U")) {
                if (r == 5) continue;
                if (!vVisited[r+5][c+5]) {
                    vVisited[r+5][c+5] = true;
                    count++;
                }
                r++;
            }
            // 아래로 이동
            if (d.equals("D")) {
                if (r == -5) continue;
                if (!vVisited[r+4][c+5]) {
                    vVisited[r+4][c+5] = true;
                    count++;
                }
                r--;
            }
            // 오른쪽으로 이동
            if (d.equals("R")) {
                if (c == 5) continue;
                if (!hVisited[r+5][c+5]) {
                    hVisited[r+5][c+5] = true;
                    count++;
                }
                c++;
            }
            // 왼쪽으로 이동
            if (d.equals("L")) {
                if (c == -5) continue;
                if (!hVisited[r+5][c+4]) {
                    hVisited[r+5][c+4] = true;
                    count++;
                }
                c--;
            }
        }
        
        return count;
    }
}