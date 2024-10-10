function solution(board) {
    // 1. 관련 변수 정의
    const N = board.length;
    const M = board[0].length;

    // 2. board를 순회하며 dp 수행
    let maxLen = 0;
    for (let r = 0; r < N; r++) {
        for (let c= 0; c < M; c++) {
            if (board[r][c] === 0) continue;
            if (r !== 0 && c !== 0) {
                const level = Math.min(board[r-1][c], board[r][c-1], board[r-1][c-1]);
                board[r][c] += level;
            }
            maxLen = Math.max(maxLen, board[r][c]);
        }
    }

    return maxLen * maxLen;
}