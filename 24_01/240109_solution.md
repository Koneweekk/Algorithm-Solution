# 240109 문제풀이

## 두 수 비교하기 (백준)

카테고리 : 조건문

풀이코드
```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

const a = parseInt(input[0]);
const b = parseInt(input[1]);

let answer;

if (a > b) {
  answer = '>';
} else if (a < b) {
  answer = '<';
} else {
  answer = '==';
}

console.log(answer);
```

[문제 링크](https://www.acmicpc.net/problem/1330) 

<hr><br>

## 시험 성적 (백준)

카테고리 : 조건문

풀이코드

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim()

const testScore = parseInt(input);
let grade;

if ( testScore >= 90 ) grade = 'A';
else if ( testScore >= 80 ) grade = 'B';
else if ( testScore >= 70 ) grade = 'C';
else if ( testScore >= 60 ) grade = 'D';
else grade = 'F';

console.log(grade);
```

[문제 링크](https://www.acmicpc.net/problem/9498)

<hr><br>

## 윤년 (백준)

카테고리 : 조건문

풀이코드

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim()

const year = parseInt(input);

if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0 ) {
  console.log(1);
} else {
  console.log(0);
}
```

[문제 링크](https://www.acmicpc.net/problem/2753) 

<hr><br>

## 사분면 고르기 (백준)

카테고리 : 조건문

풀이코드

```js
const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  const x = parseInt(input[0]);
  const y = parseInt(input[1]);

  let quadrant;

  if ( x > 0 && y > 0) quadrant = 1;
  else if ( x < 0 && y > 0) quadrant = 2;
  else if ( x < 0 && y < 0) quadrant = 3;
  else if ( x > 0 && y < 0) quadrant = 4;

  console.log(quadrant);

  process.exit();
});
```

[문제 링크](https://www.acmicpc.net/problem/14681)

<hr><br>

## 알람 시계 (백준)

카테고리 : 조건문

풀이코드

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

let [h, m] = input.map(n => parseInt(n.trim()))

h = m < 45? (h + 23) % 24 : h;
m = ( m + 15 ) % 60;

console.log(h, m);
```

[문제 링크](https://www.acmicpc.net/problem/2884) 

<hr>

## 오븐 시계 (백준)

카테고리 : 조건문

풀이코드

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let [h, m] = input[0].trim().split(' ').map(n => parseInt(n));
const time = parseInt(input[1]);

h = (h + parseInt((m + time) / 60)) % 24;
m = (m + time) % 60;

console.log(h, m);
```

[문제 링크](https://www.acmicpc.net/problem/2525)

<hr><br>

## 주사위 세개 (백준)

카테고리 : 조건문

풀이코드

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

const [a, b, c] = input.map(n => parseInt(n));

let price;

if (a === b && a === c) {
  price = 10000 + 1000 * a;
} else if (a === b || a === c) {
  price = 1000 + 100 * a
} else if (b === c) {
  price = 1000 + 100 * b
} else {
  price = 100 * Math.max(a, b, c)
}

console.log(price)
```

[문제 링크](https://www.acmicpc.net/problem/2480) 

<hr>