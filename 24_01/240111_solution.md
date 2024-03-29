# 240111 문제풀이

## 알파벳 찾기 (백준)

카테고리 : 문자열

배열과 아스키 번호를 활용하여 문자가 처음 나타난 위치를 기록하였습니다.  
인덱스도 활용할 겸 `for`문으로 문자열을 순회하였구요.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

let asciiArr = Array(26).fill(-1);

// 아스키 번호를 통해 asciiArr에 나타난 위치를 기록
for (i = 0; i < input.length; i++) {
  const asciiNumber = input[i].codePointAt();
  // 'a'의 아스키번호는 97
  if (asciiArr[asciiNumber - 97] === -1) asciiArr[asciiNumber - 97] = i;
}

console.log(asciiArr.join(' '));
```

추가 설명
- 글자의 아스키 번호 추출은 `codePointAt()`외에도 `charCodeAt()` 메서드도 사용가능합니다.
- 'A'의 아스키 번호는 65, 'a'의 아스키 번호는 97 입니다.

[문제 링크](https://www.acmicpc.net/problem/10809) 

<hr><br>

## 문자열 반복 (백준)

카테고리 : 문자열

문자열을 `split` 메서드를 통해 배열로 만든 후 `forEach`로 순회하였습니다.  
정답은 개행문자를 포함하여 한 번에 출력하는 방식을 채택하였습니다.  

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

const N = Number(input[0].trim());

let answer = '';

for (i = 1; i <= N; i++) {
  // 반복횟수와 문자열 추출
  let [n, s] = input[i].split(' ').map(item => item.trim());
  n = Number(n);

  // repeat 메서드를 통해 반복 후 정답에 이어 붙이기
  s.split('').forEach((v) => {
    answer += v.repeat(n);
  })
  // 마지막에 줄바꿈 추가 
  answer += '\n';
}

console.log(answer);
```

추가 설명
- 글자의 아스키 번호 추출은 `codePointAt()`외에도 `charCodeAt()` 메서드도 사용가능합니다.
- 'A'의 아스키 번호는 65, 'a'의 아스키 번호는 97 입니다.

[문제 링크](https://www.acmicpc.net/problem/2675) 

<hr><br>

## 단어의 개수 (백준)

카테고리 : 문자열

그냥 `input.split(' ')`만 사용하니 틀렸다고 나왔습니다.  
' ' 이런 식의 빈문자열도 포함된 것이 원인이더군요.  
`filter` 메서드를 통해 단어가 포함된 요소만 배열에 남겨두는 식으로 해결하였습니다.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

// 빈 문자열 제거
const words = input.split(' ').filter(v => v !== '');

console.log(words.length);
```

[문제 링크](https://www.acmicpc.net/problem/1152) 

<hr><br>

## 상수 (백준)

카테고리 : 문자열

숫자를 뒤집어서 대소관계를 판단하는 문제입니다.  
`a`와 `b`에 할당하는 코드가 긴데  
간단히 말하면 배열화 => 뒤집기 => 문자열화 입니다.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

// 숫자를 뒤집어서 변수에 저장
let [a, b] = input.split(' ').map(v => v.split('').reverse().join(''));

// 대소 관계 판단 후 정답 출력
console.log(Number(a) > Number(b)? a : b);
```

[문제 링크](https://www.acmicpc.net/problem/2908) 

<hr><br>

## 다이얼 (백준)

카테고리 : 문자열

처음엔 다이얼 넘버를 아스키 코드와 나누기를 활용하여 구하려고 하였습니다.  
하지만 다이얼에 할당된 알파벳 개수가 일정하지가 않아 틀리더군요.  
역시 단순한게 좋을 때도 있는 것 같습니다.

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().trim();

// 다이얼 넘버와 알파벳을 매핑
const dialNum = {
  'A':2, 
  'B':2, 
  'C':2,
  'D':3, 
  'E':3, 
  'F':3, 
  'G':4, 
  'H':4, 
  'I':4, 
  'J':5, 
  'K':5, 
  'L':5, 
  'M':6, 
  'N':6, 
  'O':6, 
  'P':7, 
  'Q':7, 
  'R':7, 
  'S':7, 
  'T':8, 
  'U':8, 
  'V':8, 
  'W':9, 
  'X':9, 
  'Y':9, 
  'Z':9, 
}

let answer = 0;

input.split('').forEach(v => {
  answer += (dialNum[v] + 1);
})

console.log(answer)
```

[문제 링크](https://www.acmicpc.net/problem/5622) 

<hr><br>