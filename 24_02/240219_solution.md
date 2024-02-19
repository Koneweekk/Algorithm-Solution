# 240219 문제풀이

## [영단어 암기는 괴로워 (백준)](https://www.acmicpc.net/problem/20920)

카테고리 : 자료구조, 문자열, 정렬, 집합과 맵

풀이코드
```js
const file = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

// 입력값 변수할당
const [N, M] = input[0].trim().split(" ").map(v => Number(v))

// 단어들을 순회하며 단어 개수 정리
const wordCounts = {};
for (let i = 1; i <= N; i++) {
  const word = input[i].trim();
  // 단어 길이가 충족되지 못한 경우
  if (word.length < M) continue;
  // 단어가 객체에 존재하지 않는 경우
  if (!wordCounts[word]) wordCounts[word] = 1;
  else wordCounts[word] += 1;
}

// 단어들을 기준에 맞춰 정렬
const words = Object.keys(wordCounts)
words.sort((a, b) => {
  if (wordCounts[a] !== wordCounts[b]) return wordCounts[b] - wordCounts[a];
  if (a.length !== b.length) return b.length - a.length;
  else if (a < b) return -1;
  else if (a > b) return 1;
  else if (a === b) return 0;
})

console.log(words.join("\n"));
```