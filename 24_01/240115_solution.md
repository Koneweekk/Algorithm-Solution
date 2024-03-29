# 240115 문제풀이

## 팰린드롬인지 확인하기 (백준)

카테고리 : 구현, 문자열

간단한 팰린드롬 문제였습니다.  

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

const word = input.split('');
const N = word.length;

let answer = 1
for (i = 0; i < parseInt(N/2); i++) {
  if (word[i] !== word[N-i-1]) answer = 0;
}

console.log(answer);
```

[문제 링크](https://www.acmicpc.net/problem/10988) 

<hr><br>

## 단어 공부 (백준)

카테고리 : 구현, 문자열

언제나 그렇듯, 아스키코드를 활용하여 알파벳 배열의 인덱스를 구해줍니다.  
이후 알파벳의 개수를 저장한 배열을 `for`문을 활용해 탐색하기 보단  
개수를 갱신할 때, `maxCount`와 현재 개수를 비교하는 식으로 답을 도출해보았습니다.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

const wordArr = input.split('');
let countArr = Array(26).fill(0);

let maxCount = 0;
let answer = '?';

wordArr.forEach(v => {
  // 대문자로 변환
  const upperCase = v.toUpperCase();
  // 알파벳 배열 인덱스 추출 후, 개수 갱신
  const index = upperCase.codePointAt() - 65;
  countArr[index] += 1;
  // 알파벳 개수와 maxCount를 비교하여 정답 갱신
  if (countArr[index] > maxCount){
    answer = upperCase;
    maxCount = countArr[index];
  } else if (countArr[index] === maxCount) {
    answer = '?';
  }
})

console.log(answer)
```

추가 설명
- 대문자변환은 `toUpperCase()`, 소문자변환은 `toLowerCase()`입니다.

[문제 링크](https://www.acmicpc.net/problem/1157) 

<hr><br>

## 크로아티아 알파벳 (백준)

카테고리 : 구현, 문자열

정규식의 힘을 빌려 관련 문자를 하나의 알파벳으로 표현하였습니다.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

const word = input.replace(/c[=-]|[ln]j|dz=|d-|s=|z=/g, 'a');
console.log(word.length);
```

추가 설명
- `/[정규식 표현]/` 형식을 통해 정규식을 사용합니다.
- 정규식 표현 뒤의 `g`는 정규식에 포함되는 모든 문자를 포함시키겠단 의미입니다.

[문제 링크](https://www.acmicpc.net/problem/2941) 

<hr><br>

## 그룹 단어 체커 (백준)

카테고리 : 구현, 문자열

여기서도 아스키 코드를 활용하여 알파벳 관련 배열을 사용하였습니다.  
이전 문제들보다 코드는 길지만 복잡한 로직은 아니니  
주석만 잘 따라가신다면 크게 어려움은 없을 겁니다.  

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim().split('\n');

// 총 수행 횟수
const N = parseInt(input[0].trim());
// 정답 기록용 변수
let answer = N;

for (i = 1; i <= N; i++) {
  // 연산을 수행할 단어
  const word = input[i].trim();
  // 사용 기록을 위한 배열
  let isUsed = Array(26).fill(false);
  // 연산 수행
  let prev = '';  // 이전 글자
  for (j = 0; j < word.length; j++) {
    const now = word[j];  // 현재 글자
    // 이전 글자와 현재 글자가 같으면 다음 글자 진행
    if (now === prev) continue;
    // 검증 배열 인덱스
    const idx = now.codePointAt() - 97;
    // 이미 사용된 글자이면 정답에서 1 차감하고 다음 단어로 넘어감
    if (isUsed[idx]) {
      answer -= 1;
      break;
    }
    // 아니라면 이전 글자와 사용 글자 배열 갱신
    prev = now;
    isUsed[idx] = true;
  }
}

console.log(answer);
```

[문제 링크](https://www.acmicpc.net/problem/1316) 

<hr><br>

## 너의 평점은 (백준)

카테고리 : 구현, 문자열

이 문제도 코드는 길어보이지만 어려울 것 없는 문제입니다.  
성적이 'P'인 과목을 제외하는 것만 조심하면 될 것 같습니다.  

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim().split('\n');

// P를 제외한 과목 수
let totalSubject = 0;
// 학점 총합
let totalScore = 0;
// 성적별 학점표
const scoreTable = {
  'A+': 4.5, 'A0': 4.0, 
  'B+': 3.5, 'B0': 3.0, 
  'C+': 2.5, 'C0': 2.0,
  'D+': 1.5, 'D0': 1.0,
  'F': 0
}

// 과목별로 연산 진행
input.forEach(v => {
  const info = v.split(' ').map(s => s.trim());
  const subjectNum = Number(info[1]);
  const grade = info[2];
  // P가 아닌 과목들만 계산
  if (grade !== 'P') {
    totalSubject += subjectNum
    totalScore += subjectNum * scoreTable[grade];
  }
})

console.log(totalScore / totalSubject);
```

[문제 링크](https://www.acmicpc.net/problem/25206) 

<hr><br>