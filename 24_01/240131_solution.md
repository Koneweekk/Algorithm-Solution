# 240131 문제풀이

## 제로 (백준)

카테고리 : 구현, 자료구조, 스택

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 변수 설장
const N = Number(input[0].trim());
const stack = Array(N);
let currentIndex = 0;
let total = 0;

// 숫자들을 처리하며 총합 구하기
for (let i = 1; i <= N; i++) {
  const number = Number(input[i].trim());
  // 숫자가 0일 경우 스택에서 데이터 삭제 후 총합 갱신
  if (number === 0) {
    total -= stack[--currentIndex];
  // 숫자가 0이 아닐 경우 스택에 데이터 넣고 총합 갱신
  } else {
    stack[currentIndex] = number
    total += number;
    currentIndex++;
  }
}

console.log(total)
```

[문제 링크](https://www.acmicpc.net/problem/10773)

<hr><br>

## 괄호 (백준)

카테고리 : 문자열, 자료구조, 스택

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 유효한 괄호인지 판단하는 함수
function isVPS (ps) {
  const len = ps.length;  // 괄호문자열의 길이
  let stackSize = 0;  // 스택의 크기
  // 스택을 활용하여 괄호 문자열이 유효한지 판단
  for (let j = 0; j < len; j ++) {
    // 좌측 괄호일 경우
    if (ps[j] === '(') stackSize ++;
    // 우측 괄호일 경우
    else {
      // 좌측 괄호가 부족함
      if (stackSize === 0) {
        return "NO";
      } else {
        stackSize--;
      }
    }
  }
  // 좌측과 우측 괄호의 개수가 맞지 않을 경우 처리
  return stackSize === 0? "YES" : "NO"
}

// 총 문제 개수
const N = Number(input[0].trim());

// 문제별로 VPS인지 판단
let result = '';
for (let i = 1; i <= N; i++) {
  const ps = input[i].trim();    // 괄호 문자열
  result += isVPS(ps) + '\n';
}

console.log(result.trim());
```

[문제 링크](https://www.acmicpc.net/problem/9012)

<hr><br>

## 균형잡힌 세상 (백준)

카테고리 : 문자열, 자료구조, 스택

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 정답을 담을 변수
let answer = "";
// 괄호 간 매칭을 담은 객체
const bracketsMatch = {"(": ")", "[": "]"}

for (let i = 0; i < input.length; i++) {
  // 관련 변수 설정
  const sentence = input[i];
  const bracketStack = ["empty"];
  let isValid = true
  // 종료조건
  if (sentence[0] === ".") break;
  // 스택을 활용해 괄호 사용이 올바른지 판단
  for ( let j = 0; j < sentence.length; j++) {
    const letter = sentence[j]
    // 괄호 좌측
    if (letter === "(" || letter=== "[") {
      bracketStack.push(bracketsMatch[letter]);
    // 괄호 우측
    } else if (letter === ")" || letter=== "]") {
      const recentBracket = bracketStack.pop();
      // 스택이 비어있거나 괄호 짝이 맞지 않는 경우
      if (recentBracket !== letter) {
        isValid = false;
        break;
      } 
    }
  }
  answer += bracketStack.length === 1 && isValid? "yes\n" : "no\n"
}

console.log(answer.trim())
```

[문제 링크](https://www.acmicpc.net/problem/4949)

<hr><br>