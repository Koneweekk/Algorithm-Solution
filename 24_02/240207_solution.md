# 240206 문제풀이

## 덱 2 (백준)

카테고리 : 자료 구조, 덱

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

const N = Number(input[0].trim());

const deque = Array(2 * N - 1);
let front = rear = N - 1

let result = "";
for (let i = 1; i <= N; i++) {
  const command = input[i].split(" ").map(v => Number(v.trim()));
  switch (command[0]) {
    case 1:
      deque[front--] = command[1];
      break;
    case 2:
      deque[++rear] = command[1];
      break;
    case 3:
      result += `${front === rear? -1 : deque[++front]}\n`
      break;
    case 4:
      result += `${front === rear? -1 : deque[rear--]}\n`
      break;
    case 5:
      result += `${rear - front}\n`
      break;
    case 6:
      result += `${front === rear? 1 : 0}\n`
      break;
    case 7:
      result += `${front === rear? -1 : deque[front + 1]}\n`
      break;
    case 8:
      result += `${front === rear? -1 : deque[rear]}\n`
      break;
    default:
      break;
  }
}

console.log(result.trim());

```

[문제 링크](https://www.acmicpc.net/problem/28279)

<hr><br>