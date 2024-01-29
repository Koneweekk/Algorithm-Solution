# 240129 문제풀이

## 나는야 포켓몬 마스터 이다솜 (백준)

카테고리 : 자료구조, 해시를 사용한 집합과 맵

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 할당
const [N, M] = input[0].trim().split(' ').map(v => Number(v));
const numToName = Array(N + 1);
const nameToNum = {}

// 포켓몬 관련 배열 및 객체 정보 갱신
for (let i = 1; i <= N; i++) {
  const pokemon = input[i].trim();
  numToName[i] = pokemon;
  nameToNum[pokemon] = i;
}

// 문제들을 처리하여 정답 출력
result = '';
for (let i = N + 1; i <= N + M; i++) {
  const problem =  input[i].trim();
  const answer = isNaN(Number(problem)) ? nameToNum[problem] : numToName[Number(problem)];
  result += answer + '\n';
}

console.log(result)
```

[문제 링크](https://www.acmicpc.net/problem/1620)

<hr><br>

## 숫자 카드 2 (백준)

카테고리 : 자료구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 할당
const N = Number(input[0].trim());  // 보유 중인 카드 개수
const M = Number(input[2].trim());  // 개수를 구하고자 하는 카드 개수
const cards = input[1].split(' ').map(v => v.trim());
const prblems = input[3].split(' ').map(v => v.trim());
const cardsNum = {} 

// 카드 개수 기록하기
for (let i = 0; i < N; i++) {
  let num = cardsNum[cards[i]];
  cardsNum[cards[i]] = typeof num === 'undefined' ? 1 : num + 1;
}

// 찾고 있는 카드가 몇 개인지 구하기
const result = Array(M);
for (let i = 0; i < M; i++) {
  const answer = cardsNum[prblems[i]]
  result[i] = typeof answer === 'undefined' ? 0 : answer;
}

console.log(result.join(' '));
```

[문제 링크](https://www.acmicpc.net/problem/10816)

<hr><br>

## 듣보잡  (백준)

카테고리 : 자료구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 할당
const [ N, M ] = input[0].split(' ').map(v => Number(v.trim()))  // [ 사람수, 문제수 ]
const people = {}

// 사람 기록하기
for (let i = 1; i <= N; i++) {
  const person = input[i].trim();
  people[person] = true
}

// 찾고 있는 사람이 존재하는지 판단 후 정답 갱신
let count = 0;
let result = [];
for (let i = N + 1; i <= N + M; i++) {
  const problem = input[i].trim();
  if (people[problem]) {
    result.push(problem)
    count++;
  }
}

// 정렬 후 형식에 맞춰 출력
result.sort();
console.log(count + '\n' + result.join('\n'));
```

[문제 링크](https://www.acmicpc.net/problem/1764)

<hr><br>