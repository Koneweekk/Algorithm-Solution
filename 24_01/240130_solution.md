# 240130 문제풀이

## 서로 다른 부분 문자열의 개수 (백준)

카테고리 : 자료구조, 문자열, 해시를 사용한 집합과 맵

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

// 변수 할당
const N = input.length;  // 문자열 길이
const wordSet = new Set();

// 모든 경우의 수 체크
for (let wordLen = 1; wordLen <= N; wordLen++){  // 부분 문자열의 길이
  for (let start = 0; start < N + 1 - wordLen; start++) {  // 부분을 시작하는 위치
    wordSet.add(input.slice(start, start + wordLen));
  }
}

console.log(wordSet.size)
```

[문제 링크](https://www.acmicpc.net/problem/11478)

<hr><br>

## 대칭 차집합 (백준)

카테고리 : 자료구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 할당
const [ numA, numB ] = input[0].split(' ').map(v => Number(v.trim()));
const A = input[1].split(' ').map(v => v.trim());
const B = input[2].split(' ').map(v => v.trim());

// A와 B의 합집합 구하기
const unionAB = new Set([...A, ...B]);

// 교집합의 개수롤 추론하여 정답 출력
const intersectionSize = numA + numB - unionAB.size
console.log(numA + numB - 2 * intersectionSize);
```

[문제 링크](https://www.acmicpc.net/problem/1269)

<hr><br>

## 스택 2 (백준)

카테고리 : 자료구조, 스택

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 할당
const N = Number(input[0].trim());
const stack = Array(N);
let stackSize = 0;

// 스택과 관련된 명령어들을 수행
let result = '';
for (let i = 1; i <= N; i++) {
  // 명령어 변수 할당
  const operation = input[i].split(' ').map(v => Number(v.trim()));
  // 조건문을 통해 명령어 종류를 판단 후 처리
  if ( operation[0] === 1 ) {
    stack[stackSize] = operation[1];
    stackSize += 1;
  } else if ( operation[0] === 2 ) {
    const value = stackSize === 0? -1 : stack[--stackSize];
    result += value + '\n';
  } else if ( operation[0] === 3 ) {
    result += stackSize + '\n';
  } else if ( operation[0] === 4 ) {
    const value = stackSize === 0? 1 : 0;
    result += value + '\n';
  } else if ( operation[0] === 5 ) {
    const value = stackSize === 0? -1 : stack[stackSize - 1];
    result += value + '\n';
  }
}

console.log(result.trim());
```

[문제 링크](https://www.acmicpc.net/problem/28278)

<hr><br>