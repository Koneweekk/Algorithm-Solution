# 240216 문제풀이

## [인사성 밝은 곰곰이 (백준)](https://www.acmicpc.net/problem/25192)

카테고리 : 자료구조, 맵

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수할당
const N = Number(input[0].trim());

// 이모티콘을 날린 사람 명단과 횟수
const emoticons = new Set()
let result = 0

// 채팅창을 순회하며 정답 구하기
for (let i = 1; i <= N; i++) {
  const action = input[i].trim();
  // 사람이 채팅방을 들어왔을 때
  if (action === "ENTER") {
    result += emoticons.size;
    emoticons.clear();
  // 그 외의 채팅 or 이모티콘 인사
  } else {
    emoticons.add(action);
  }
}

// 마지막 이모티콘 명단이 집계되지 않았으므로 집계하여 출력
console.log(result + emoticons.size)
```

<hr><br>

## [붙임성 좋은 총총이 (백준)](https://www.acmicpc.net/problem/26069)

카테고리 : 자료구조, 맵

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수할당
const N = Number(input[0].trim());

// 춤추고 있는 사람 명단
const dancers = new Set(["ChongChong"])

// 기록을 순회하며 춤추는 사람 명단 구하기
for (let i = 1; i <= N; i++) {
  const meeting = input[i].trim().split(" ");
  if (dancers.has(meeting[0])) dancers.add(meeting[1]);
  else if (dancers.has(meeting[1])) dancers.add(meeting[0]);
}

// 마지막 이모티콘 명단이 집계되지 않았으므로 집계하여 출력
console.log(dancers.size)
```