# 240221 문제풀이

## [계단 오르기 (백준)](https://www.acmicpc.net/problem/2579)

카테고리 : 다이나믹 프로그래밍

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수에 할당
const N = Number(input[0].trim());
const stairs = input.slice(1, N + 1).map(v => Number(v.trim()));

// 계단별 최대 점수 배열
const maxScores = new Array(N).fill().map((v,i) => new Array(2).fill(stairs[i]));

// 계단들을 뛰며 상황별 최대 점수를 구하기
for (let i = 0; i < N; i++) {
  if (i + 1 < N) maxScores[i + 1][1] += maxScores[i][0];
  if (i + 2 < N) maxScores[i + 2][0] += Math.max(...maxScores[i]);
}

console.log(Math.max(...maxScores[N-1]))
```

<hr><br>

## [1로 만들기 (백준)](https://www.acmicpc.net/problem/1463)

카테고리 : 다이나믹 프로그래밍

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수에 할당
const N = Number(input[0].trim());

// 최소 횟수들을 담을 배열
const minCounts = new Array(N + 1).fill(Infinity);
minCounts[1] = 0;

// 1부터 시작하여 N이 되는 최소횟수 구하기
for (let i = 1; i < N; i++) {
  if ( i + 1 <= N ) minCounts[i+1] = Math.min(minCounts[i+1], minCounts[i] + 1)
  if ( 2*i <= N ) minCounts[2*i] = Math.min(minCounts[2*i], minCounts[i] + 1)
  if ( 3*i <= N ) minCounts[3*i] = Math.min(minCounts[3*i], minCounts[i] + 1)
}

console.log(minCounts[N])
```