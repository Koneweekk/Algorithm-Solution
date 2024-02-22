# 240222 문제풀이

## [쉬운 계단 수 (백준)](https://www.acmicpc.net/problem/10844)

카테고리 : 다이나믹 프로그래밍

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수에 할당
const N = Number(input[0].trim());

// 인덱스와 가장 뒷자리 숫자가 일치하는 숫자의 개수 배열
const numCounts = new Array(10).fill(1);
numCounts[0] = 0;

// 숫자 뒷자리 숫자를 늘려가며 계단 수 개수 측정
for (let i = 0; i < N - 1; i++) {
  const tmp = [...numCounts];
  for (let n = 1; n < 9; n ++) {
    numCounts[n] = (tmp[n-1] + tmp[n+1]) % 1000000000
  }
  numCounts[0] = tmp[1] % 1000000000;
  numCounts[9] = tmp[8] % 1000000000;
}

result = numCounts.reduce((acc, cur) => acc + cur)
console.log(result % 1000000000)
```