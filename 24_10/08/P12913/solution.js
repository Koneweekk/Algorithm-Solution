function solution(land) {
  // 1. 활용할 변수 정리
  // 1.1 행 길이
  const N = land.length;
  // 1.2 최대 점수를 기록해둘 이중 배열
  const maxScores = new Array(N).fill(0).map(() => new Array(4).fill(0));
  maxScores[0] = land[0];

  // 2 dp를 통해 각 칸 별 최대값 환산
  for (let r = 1; r < N; r++) {
    const pr = r - 1;
    for (let c = 0; c < 4; c++) {
      for (let pc = 0; pc < 4; pc++) {
        // 열이 같으면 패스
        if (c === pc) continue;
        // 아니면 최대값 기록
        if (maxScores[r][c] < maxScores[pr][pc] + land[r][c]) {
          maxScores[r][c] = maxScores[pr][pc] + land[r][c];
        }
      }
    }
  }

  return Math.max(...maxScores[N-1]);
}

console.log(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]));