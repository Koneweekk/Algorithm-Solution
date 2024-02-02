# 240202 문제풀이

## 토마토 (백준)

카테고리 : 그래프 탐색, 너비 우선 탐색

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 행과 열 길이
const [ N, M ] = input[0].split(" ").map(v => Number(v.trim()));

// 농장의 상태
const farm = Array(M);
for (let i = 1; i <= M; i++) {
  const row = input[i].split(" ").map(v => Number(v.trim()));
  farm[i-1] = row;
}

// 현재 익은 토마토 위치 찾고 개수 갱신
const queue = Array(N * M);  // bfs 구현을 위한 큐
let [front, rear] = [0, 0]
let tomatoCount = 0;  // 익은 토마토 개수
let totalCount = N * M  // 익어야하는 토마토 총 개수
for (let row = 0; row < M; row++) {
  for (let col = 0; col < N; col++) {
    // 토마토가 있지 않은 칸이면 총 개수 감소
    if (farm[row][col] === -1) {
      totalCount--;
    // 토마토가 있는 칸이면 큐에 넣어준 후 개수 증가
    } else if (farm[row][col] === 1) {
      queue[rear] = [row, col, 0];
      tomatoCount++;
      rear++;
    }
  }
}

// bfs를 통해 최소 날짜 구하기
const direction = [[1, 0], [0, 1], [-1, 0], [0, -1]]  // 동서남북 탐색을 위한 객체
let minDay = 0;
while (front !== rear) {
  // 행, 열, 현재 위치까지의 최단 날짜
  const [ row, col, day ] = queue[front];
  // 최소 날짜 갱신
  minDay = day
  // 현재 위치의 사방을 탐색
  for (const d of direction) {
    // 현재 위치로부터 탐색할 좌표
    const newRow = row + d[0];
    const newCol = col + d[1];
    // 유효하지 않은 좌표일 경우
    if (newRow < 0 || newRow >= M || newCol < 0 || newCol >= N) continue;
    // 덜익은 토마토가 있는 칸일 경우
    if (farm[newRow][newCol] === 0) {
      queue[rear] = [newRow, newCol, day + 1];
      farm[newRow][newCol] = 1;
      tomatoCount++;
      rear++;
    }
  }
  front++;
}

// 익지 못한 토마토가 없는지 확인 후 정답 출력
console.log(tomatoCount === totalCount ? minDay : -1)
```

[문제 링크](https://www.acmicpc.net/problem/7576)

<hr><br>

## 불! (백준)

카테고리 : 그래프 탐색, 너비 우선 탐색

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 행과 열 길이
const [ N, M ] = input[0].split(" ").map(v => Number(v.trim()));

// 미로의 상태
const maze = Array(N);
for (let i = 1; i <= M; i++) {
  const row = input[i].trim().split("");
  maze[i-1] = row;
}

// 현재 불의 위치와 지훈이의 위치를 기록
let startPoint = []
const queue = [[]]
let rear = 1;
let front = 0;
for (let row = 0; row < N; row++) {
  for (let col = 0; col < M; col++) {
    // 지훈이의 위치를 가장 앞에 넣어줌
    if (maze[row][col] === "J") {
      queue[0] = ["J", row, col]
      startPoint = [row, col]
    // 불의 위치는 지훈이 뒤로 넣어줌
    } else if (maze[row][col] === "F") {
      queue.push(["F", row, col])
      rear++;
    }
  }
}

// bfs를 통해 최소 시간 구하기
const direction = [[1, 0], [0, 1], [-1, 0], [0, -1]]  // 동서남북 탐색을 위한 객체
let isPossible = false;
while (front !== rear) {
  // 움직이는 대상, 행, 열, 현재 위치까지의 최단 거리
  const [target, row, col] = queue[front];
  // 움직이는 대상이 지훈이일 경우
  if (target === "J") {
    // 가장 자리에 도달한 경우 출력 후 반복문 종료
    if (row === 0 || row === N-1 || col === 0 || col === M-1) {
      isPossible = true;
      console.log(Math.abs(startPoint[0] - row) + Math.abs(startPoint[1] - col) + 1);
      break;
    }
    // 현재 위치의 사방을 탐색
    for (const d of direction) {
      // 현재 위치로부터 탐색할 좌표
      const newRow = row + d[0];
      const newCol = col + d[1];
      // 좌표가 유효 범위를 벗어난 경우
      if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) continue;
      // 지훈이가 이동할 수 있는 칸일 경우 지훈이 이동
      if (maze[newRow][newCol] === ".") {
        queue.push(["J", newRow, newCol])
        rear++;
      }
    }
  }
  // 움직이는 대상이 불일 경우
  if (target === "F") {
    // 현재 위치의 사방을 탐색
    for (const d of direction) {
      // 현재 위치로부터 탐색할 좌표
      const newRow = row + d[0];
      const newCol = col + d[1];
      // 유효하지 않은 좌표일 경우
      if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) continue;
      // 벽이 아닌 경우 불 표시
      if (maze[newRow][newRow] === "J" || maze[newRow][newCol] === ".") {
        queue.push(["F", newRow, newRow])
        maze[newRow][newCol] = "F";
        rear++;
      }
    }
  }
  queue[front] = 0
  front ++;
}

// 탈출이 불가능할 경우
if (!isPossible) console.log("IMPOSSIBLE")
```

[문제 링크](https://www.acmicpc.net/problem/4179)

<hr><br>