# 240213 문제풀이

## 하노이 탑 이동 순서 (백준)

카테고리 : 재귀

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().trim();

const N = Number(input);

let result = "";
let count = 0

function hanoi(height, start, target) {
  if (!height) return;
  hanoi(height - 1, start, 6 - start - target);
  result += `${start} ${target}\n`
  count++;
  hanoi(height - 1, 6 - start - target, target);
}

hanoi(N, 1, 3);
console.log(count);
console.log(result.trim());
```

[문제 링크](https://www.acmicpc.net/problem/11729)

<hr><br>