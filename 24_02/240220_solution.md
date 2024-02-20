# 240220 문제풀이

## [칸토어 집합 (백준)](https://www.acmicpc.net/problem/4779)

카테고리 : 분할정복, 재귀

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 칸토어 집합 함수
function cantor(n) {
  if (n === 0) return "-";
  else return cantor(n-1) + " ".repeat(3**(n-1)) + cantor(n-1)
}

// 케이스별로 함수를 실행하여 출력값 산출
for (let i = 0; i < input.length - 1; i++) {
  const N = Number(input[i].trim());
  console.log(cantor(N));
}
```