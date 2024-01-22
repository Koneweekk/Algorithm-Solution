# 240122 문제풀이

## 좌표 정렬하기 (백준)

카테고리 : 정렬

```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 정렬할 좌표들의 배열
const N = Number(input[0].trim())
let pointArr = [];

for (let i = 1; i <= N; i++) {
  let point = input[i].trim().split(' ');
  pointArr.push(point.map(v => Number(v.trim())))
}

// sort 메서드를 통한 좌표 정렬
pointArr.sort((a,b) => {
  return a[0] !== b[0]? a[0] - b[0] : a[1] - b[1];
})

// 형식에 맞게 출력
const result = pointArr.map(v => `${v[0]} ${v[1]}`);
console.log(result.join('\n'));
```

[문제 링크](https://www.acmicpc.net/problem/11650) 

<hr><br>

## 단어 정렬 (백준)

카테고리 : 정렬

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 총 단어 개수
const N = Number(input[0].trim())

// Set을 활용하여 중복 단어 제거
let wordsSet = new Set();
for (let i = 1; i <= N; i++) {
  wordsSet.add(input[i].trim());
}

// 단어 집합 배열화
let wordsArr = [...wordsSet];

// sort 메서드를 활용하여 정렬
wordsArr.sort((a, b) => {
  const [aLen, bLen] = [a.length, b.length];
  // 단어 길이 우선 정렬
  if (aLen !== bLen) return aLen - bLen;
  // 길이가 같으면 사전순 정렬
  else if ( a < b ) return -1;
  else if ( a > b) return 1;
  else return 0;
})

// 형식에 맞게 출력
console.log(wordsArr.join('\n'));
```

[문제 링크](https://www.acmicpc.net/problem/1181) 

<hr><br>

## 나이순 정렬 (백준)

카테고리 : 정렬

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

// 가입한 사람들의 정보를 배열화
const N = Number(input[0].trim())
let people = [];
for (let i = 1; i <= N; i++) {
  const person = input[i].trim().split(' ');
  people.push([Number(person[0]), person[1]]);
}

// 나이순, 가입순으로 오름차순 정렬
people.sort((a, b) => {
  return a[0] - b[0];
})

// 형식에 맞게 출력
const resultArr = people.map(v => `${v[0]} ${v[1]}`)
console.log(resultArr.join('\n'))
```

[문제 링크](https://www.acmicpc.net/problem/10814)

<hr><br>

## 좌표 압축 (백준)

카테고리 : 정렬

풀이코드
```js
const file = process.platform === 'linux' ? '/dev/stdin' : 'example.txt';
let input = require('fs').readFileSync(file).toString().split('\n');

const N = Number(input[0].trim());

// 중복을 제거한 숫자 배열 추출
const numbersRaw = input[1].split(' ');
const numberSet = new Set(numbersRaw);
const numbersArr = [...numberSet];

// 오름차순 정렬
numbersArr.sort((a, b) => Number(a) - Number(b));

// 숫자 : 순서 형식으로 key, value 쌍을 기록
const ordersObj = new Object();
numbersArr.forEach((v, i) => {
  ordersObj[v] = i;
})

// 기록한 순서쌍을 활용하여 원본 숫자 배열에서 순서를 추출
let ordersArr = Array(N);
for (let i = 0; i < N; i++) {
  ordersArr[i] = ordersObj[numbersRaw[i]];
}

// 형식에 맞게 출력
console.log(ordersArr.join(' '));
```

[문제 링크](https://www.acmicpc.net/problem/18870)

<hr><br>