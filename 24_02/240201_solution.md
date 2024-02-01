# 240201 문제풀이

## 그림 (백준)

카테고리 : 그래프, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 행과 열 길이
const [ N, M ] = input[0].split(" ").map(v => Number(v.trim()));

// 그림의 상태
const paper = Array(N);
for (let i = 1; i <= N; i++) {
  const row = input[i].split(" ").map(v => Number(v.trim()));
  paper[i-1] = row
}

// 최대넓이와 그림 개수
let numberOfPicture = 0;
let maxWidth = 0; 

// bfs를 통해 그림의 넓이를 구하는 함수
function findWidth(r, c) {
  // 방향을 정의한 객체
  const direction = [[1, 0], [0, 1], [0, -1], [-1, 0]];
  // 현재 그림의 넓이
  let width = 1;
  // bfs 구현을 위한 큐
  let queue = [[r, c]];  
  // bfs를 통해 넓이 구하기
  while (queue.length !== 0) {
    const [r, c] = queue.shift();
    for (const d of direction) {
      const nr = r + d[0];
      const nc = c + d[1];
      if ( nr < 0 || nr >= N || nc < 0 || nc >= M ) continue;
      if ( paper[nr][nc] === 1 ) {
        paper[nr][nc] = 0;
        width += 1;
        queue.push([nr, nc])
      }
    }
  }
  // 최대 넓이 갱신
  if ( width > maxWidth ) maxWidth = width;
}

// 종이의 좌표를 돌며 그림들의 개수와 최대 넓이 구하기
for (let row = 0; row < N; row++) {
  for (let col = 0; col < M; col++) {
    // 그림의 일부분이라 판단되면 그림의 넓이 구하기
    if (paper[row][col] === 1) {
      // 그림 개수 추가
      numberOfPicture++;
      // 방문 표시
      paper[row][col] = 0
      findWidth(row, col);
    }
  }
}

console.log(numberOfPicture + "\n" + maxWidth);
```

[문제 링크](https://www.acmicpc.net/problem/1926)

<hr><br>

## 미로 탐색 (백준)

카테고리 : 그래프, 그래프 탐색, 너비 우선 탐색

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 행과 열 길이
const [ N, M ] = input[0].split(" ").map(v => Number(v.trim()));

// 미로의 상태
const maze = Array(N);
for (let i = 1; i <= N; i++) {
  const row = input[i].split("").map(v => Number(v.trim()));
  maze[i-1] = row;
}

// bfs를 통해 최단 거리 찾기
maze[0][0] = 0;  // 시작 위치 방문 표시
const queue = [[0, 0, 1]];  // bfs 구현을 위한 큐
const direction = [[1, 0], [0, 1], [-1, 0], [0, -1]]  // 동서남북 탐색을 위한 객체
bfs: while (queue.length > 0) {
  // 행, 열, 현재 위치까지의 최단 거리
  const [ row, col, dist ] = queue.shift();
  // 현재 위치의 사방을 탐색
  for (const d of direction) {
    // 현재 위치로부터 탐색할 좌표
    const newRow = row + d[0];
    const newCol = col + d[1];
    // 유효하지 않은 좌표일 경우
    if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) continue;
    // 도착 지점일 경우
    if (newRow === N-1 && newCol === M - 1) {
      console.log(dist + 1);
      break bfs; 
    }
    // 도착지점이 아닌 길인 경우
    if (maze[newRow][newCol] === 1) {
      maze[newRow][newCol] = 0;
      queue.push([newRow, newCol, dist + 1]);
    }
  }
}
```

[문제 링크](https://www.acmicpc.net/problem/2178)

<hr><br>