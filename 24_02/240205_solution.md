# 240205 문제풀이

## 도키도키 간식드리미 (백준)

카테고리 : 자료 구조, 스택

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

const N = Number(input[0].trim());
const line = input[1].trim().split(" ").map(v => Number(v));
const stack = [];

// 현재 줄 처리
let order = 1;
let index = 0;
while ( index < N ) {
  if ( order === line[index] ) {
    order++;
    index++;
  } else if ( order === stack[stack.length -1 ] ) {
    stack.pop();
    order++;
  } else {
    stack.push(line[index])
    index++;
  }
}

// 추가 줄 처리
let result = "Nice"
while (stack.length > 0) {
  const current = stack.pop();
  if (current !== order) {
    result = "Sad";
    break;
  }
  order++;
}

console.log(result)
```

[문제 링크](https://www.acmicpc.net/problem/12789)

<hr><br>

## 카드2 (백준)

카테고리 : 자료 구조, 큐

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().trim();;

const N = Number(input);
const arr = Array(N).fill(1).map((v, i) => i + 1);

let [ front, rear ] = [0, N-1]

while (front !== rear) {
  arr.push(arr[front + 1]);
  front += 2;
  rear++;
}

console.log(arr[front])
```

[문제 링크](https://www.acmicpc.net/problem/2164)

<hr><br>

## 요세푸스 문제 0 (백준)

카테고리 : 자료 구조, 큐

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().trim();;

const N = Number(input);
const arr = Array(N).fill(1).map((v, i) => i + 1);

let [ front, rear ] = [0, N-1]

while (front !== rear) {
  arr.push(arr[front + 1]);
  front += 2;
  rear++;
}

console.log(arr[front])
```

[문제 링크](https://www.acmicpc.net/problem/11866)

<hr><br>