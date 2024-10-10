function solution(money) {
  const N = money.length;

  // 메모이제이션을 위한 배열
  const firstStart = new Array(N - 1).fill(0); // 첫번째 집 출발
  const secondStart = new Array(N - 1).fill(0); // 두번째 집 출발
  const thirdStart = new Array(N - 1).fill(0); // 세번째 집 출발

  // 메모이제이션 배열 초기화
  firstStart[0] = money[0];
  secondStart[0] = money[1];
  thirdStart[0] = money[2];
  if (N > 3) {
    firstStart[2] = money[0] + money[2];
    secondStart[2] = money[1] + money[3];
    thirdStart[2] = money[2] + money[4 % N];
  }

  // dp 수행
  for (let i = 3; i < N - 1; i++) {
    firstStart[i] = money[i] + Math.max(firstStart[i - 2], firstStart[i - 3]);
    secondStart[i] =
      money[i + 1] + Math.max(secondStart[i - 2], secondStart[i - 3]);
    thirdStart[i] =
      money[(i + 2) % N] + Math.max(thirdStart[i - 2], thirdStart[i - 3]);
  }

  // 최대값 출력

  return Math.max(
    firstStart[N - 2],
    firstStart[N - 3],
    secondStart[N - 2],
    secondStart[N - 3],
    thirdStart[N - 2],
    thirdStart[N - 3]
  );
}
